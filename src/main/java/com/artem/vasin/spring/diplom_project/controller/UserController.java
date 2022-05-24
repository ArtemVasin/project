package com.artem.vasin.spring.diplom_project.controller;

import com.artem.vasin.spring.diplom_project.entity.*;
import com.artem.vasin.spring.diplom_project.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
public class UserController {

    @Autowired
    private final UserService userService;
    @Autowired
    private final PostService postService;
    @Autowired
    private final NewService newService;
    @Autowired
    private final FriendService friendService;
    @Autowired
    private final MessageService messageService;

    public UserController(UserService userService, PostService postService, NewService newService, FriendService friendService, MessageService messageService) {
        this.userService = userService;
        this.postService = postService;
        this.newService = newService;
        this.friendService = friendService;
        this.messageService = messageService;
    }

    // 1. показ информации и постов авторизованного пользователя
    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public Object currentUserName(Principal principal) {
        String nameBuffer = principal.getName();
        User user = userService.getUsersForLogin(nameBuffer);
        UserForAnket u = new UserForAnket();
        BeanUtils.copyProperties(user, u);
        return u;
    }

    // 1a. показ постов определенного пользователя
    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    @ResponseBody
    public Object currentUserPosts(Principal principal) {
        String nameBuffer = principal.getName();
        User user = userService.getUsersForLogin(nameBuffer);
        List<Post> posts = user.getPosts();
        return posts;
    }

    // 2. показ сообщений определенного пользователя
    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    @ResponseBody
    public Object currentUserMessages(Principal principal) {
        String nameBuffer = principal.getName();
        User user = userService.getUsersForLogin(nameBuffer);
        List<Message> messages = user.getMessages();
        return messages;
    }

    // 3. показ фотографий определенного пользователя
    @RequestMapping(value = "/photo", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserPhoto(Principal principal) throws IOException, ClassNotFoundException {
        String nameBuffer = principal.getName();
        User user = userService.getUsersForLogin(nameBuffer);
        List<Image> photo = user.getImages();
        for (Image photoBuffer : photo) {
            try (FileInputStream input = new FileInputStream(photoBuffer.getLink());
                 FileOutputStream output = new FileOutputStream("note.txt")) {
                byte[] buffer = new byte[65536]; // 64Kb
                while (input.available() > 0) {
                    int real = input.read(buffer);
                    output.write(buffer, 0, real);
                }
            }
        }
//        FileInputStream input = new FileInputStream("notes4.txt");
        return "фотографии успешно загружены";
    }
// часть метода, если нужно будет через метод mageIO
//        BufferedImage input = null;
//        for (Image photoBuffer : photo) {
//            input = ImageIO.read(new File(photoBuffer.getLink()));

    //       BufferedImage input = null;


//             File inputFile = new File("101.jpg");
//        try(  BufferedReader bufferReader = new BufferedReader(new FileReader(inputFile));
//        BufferedWriter bw = new BufferedWriter(new FileWriter("notes4.txt")) {
    //  ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile));
    // Object products = bufferReader.readLine();
    // File output = new File("katana_grey.jpg");
    //  ImageIO.write(input, "jpg", new File("katana1.jpg"));
//            BufferedImage result = new BufferedImage(input.getWidth(), input.getHeight(), input.getType());
//             File outputFile = new File("image.jpg");
//            ImageIO.write(result, "jpg", outputFile);
    //     }


    // 4. показ друзей определенного пользователя
    @RequestMapping(value = "/friends", method = RequestMethod.GET)
    @ResponseBody
    public Object currentUserFriends(Principal principal) {
        String nameBuffer = principal.getName();
        User user = userService.getUsersForLogin(nameBuffer);
        List<Friend> friends = user.getFriends();
        return friends;
    }

    // 5. метод редактирования пользователя
    @Transactional
    @PutMapping(value = "/edit")
    public void currentUserEdit(Principal principal, @RequestBody User user) {
        String nameBuffer = principal.getName();
        User userEdit = userService.getUsersForLogin(nameBuffer);
        if (userEdit.getId() == user.getId()) {
            userEdit.setSurname(user.getSurname());
            userEdit.setName(user.getName());
            userEdit.setPhoneNumber(user.getPhoneNumber());
            userEdit.setEmail(user.getEmail());
            userService.saveUsers(userEdit);
        }
    }

    // 6. метод вывода всех новостей
    @GetMapping({"/news"})
    public List<New> getAllNews() {
        List<New> news = this.newService.getAllNews();
        return news;
    }

    // 7. поиск по словам
    @GetMapping({"/search"})
    public List search(@RequestParam(name = "word") String word) {
        try {
            List list = Arrays.asList(newService.findAllByPostNews(word),
                    postService.findAllByNamePosts(word),
                    userService.findAllBySurname(word),
                    friendService.findAllByLastNameFriend(word),
                    messageService.findAllByContent(word));
            return list;
        } catch (RuntimeException e) {
            throw new RuntimeException("Нет информации по поиску");
        }
    }

    //  8. метод для сохранения нового пользователя,
    @Transactional
    @PostMapping({"/reg"})
    public void saveUsers(@RequestBody User user, HttpServletResponse response) {
        if (userService.getUsersForLogin(user.getLogin()) == null) {
            userService.saveUsers(user);
        } else {
            System.out.println("This login is already occupied");
        }
        try {
            response.sendRedirect("http://localhost:8080/login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



































//    @PostMapping({"/aut"})
//    public User autUser (@RequestBody User u, HttpServletResponse response) throws IOException {
//        User user= userService.autUser(u.getLogin(), u.getPassword());
//        response.sendRedirect("http://localhost:8080/api/user/" + user.getId());
//        return  user;
//    }

//сейчас возвращает логин, роль, пароль null
//    @RequestMapping(value = "/username", method = RequestMethod.GET)
//    @ResponseBody
//    public Object currentUserName(Authentication authentication) {
//        return authentication.getPrincipal();
//    }


