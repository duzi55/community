package xyz.sdju.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.sdju.community.dto.AccessTokenDTO;
import xyz.sdju.community.dto.GitHubUserDTO;
import xyz.sdju.community.mapper.UserMapper;
import xyz.sdju.community.model.User;
import xyz.sdju.community.provider.GitHubProvider;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-07-24 12:23
 */
@Controller
public class AuthorizeController {
    @Autowired
    private GitHubProvider gitHubProvider;
    @Value("${github.clint.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect_uri}")
    private String redirectUri;
    @Resource
    UserMapper userMapper;
    /**
     * 已经获取到了授权
     * 现在是github返回code
     * @param code
     * @param state
     * @return
     */
    @GetMapping("/callback")
    public String callBack(@RequestParam(name = "code")String code,
                           @RequestParam(name="state") String state,
                           HttpServletResponse httpServletResponse
                            ){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        //携带github返回到code信息，发送post请求到github获取用户到信息
        String accessToken = gitHubProvider.getAccessToken(accessTokenDTO);
        GitHubUserDTO gitHubUserDTO = gitHubProvider.getUser(accessToken);
        if(gitHubUserDTO!=null){
            User user = new User();
            user.setAccountId(String.valueOf(gitHubUserDTO.getId()));
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            user.setName(gitHubUserDTO.getName());
            userMapper.insert(user);
            httpServletResponse.addCookie(new Cookie("token",token));
            return "redirect:/";

        }else {
            return "redirect:/";
        }

    }
}
