package xyz.sdju.community.provider;

import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.springframework.stereotype.Component;
import xyz.sdju.community.dto.AccessTokenDTO;
import xyz.sdju.community.dto.GitHubUserDTO;

import java.io.IOException;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-07-24 12:33
 */
//把这个类交给spring 的上下文，不需要实例话创建对象
@Component
 public class GitHubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
        final MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();
        //将DTO转换为json发给github获取token
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String[] split=string.split("&");
            String tokenString=split[0];
            return tokenString.split("=")[1];
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public GitHubUserDTO getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string= response.body().string();
            //json转java类对象
            GitHubUserDTO user=JSON.parseObject(string,GitHubUserDTO.class);
            return user;
        } catch (IOException e) {

        }
        return null;

    }
}
