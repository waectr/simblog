package com.waectr.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.waectr.blog.service.BlogService;
import com.waectr.blog.service.TagAndBlogService;
import com.waectr.blog.service.TagService;
import com.waectr.blog.service.TypeService;
import com.waectr.blog.service.model.Blog;
import com.waectr.blog.service.model.Tag;
import com.waectr.blog.service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class BlogController {

    private static final String INPUT="admin/blogs-input";
    private static final String LIST="admin/blogs";
    private static final String REDIRECT_LIST="redirect:/admin/blogs";

    @Autowired
    BlogService blogService;

    @Autowired
    TypeService typeService;

    @Autowired
    TagService tagService;

    @Autowired
    TagAndBlogService tagAndBlogService;

    @GetMapping("/blogs")
    public String blogs(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, String name, HttpSession session){
        User user = (User) session.getAttribute("user");
        PageHelper.startPage(pageNum,10);
        List<Blog> list = blogService.list(name,user);//不带条件查询
        PageInfo<Blog> pageInfo = new PageInfo<Blog>(list);
        model.addAttribute("pageInfo",pageInfo);
        return LIST;
    }

    @GetMapping("/blogs/input")
    public String input(Model model){
        model.addAttribute("types",typeService.list());
        model.addAttribute("tags",tagService.list());
        model.addAttribute("blog",new Blog());
        return INPUT;
    }
//    @RequestParam("published") String published,
//    @RequestParam("title") String title,
//    @RequestParam("typeId") String typeId,
//    @RequestParam("tagId") String tagId,
//    @RequestParam("firstPicture") String firstPicture,
//    @RequestParam("recommend") String recommend,
//    @RequestParam("shareStatement") String shareStatement,
//    @RequestParam("appreciation") String appreciation,
//    @RequestParam("commenttabled") String commenttabled,
    @PostMapping("/blogs")
    public String post(Blog blog, RedirectAttributes attributes,HttpSession session,
                       @RequestParam("tagIds") String tagIds,@RequestParam("typeId")String typeId){
        //TODO 非空校验
        User user = (User) session.getAttribute("user");
        blog.setUser(user);
        blog.setType(typeService.getType(new Long(typeId)));
        blog.setTags(tagService.ListTag(tagIds));
        blog.setFlag("");

        Blog blog1 = blogService.saveBlog(blog);

        if(blog1==null){
            attributes.addFlashAttribute("message","操作成功");
        }else {
            attributes.addFlashAttribute("message","操作失败");
        }
        return REDIRECT_LIST;
    }
//    delete
    @GetMapping("/blogs/{id}/delete")
    public String delet(@PathVariable Long id){
        blogService.deleteBlog(id);
        return REDIRECT_LIST;
    }
    @GetMapping("/blogs/{id}/input")
    public String editInput(Model model,@PathVariable Long id){
        model.addAttribute("types",typeService.list());
        model.addAttribute("tags",tagService.list());
        Blog blog = blogService.getBlog(new Long(id));
        List<Tag> tagsByBlogId = tagAndBlogService.getTagsByBlogId(new Integer(id.toString()));
        String tagIds = getTagsString(tagsByBlogId);
        model.addAttribute("tagIds",tagIds);
        model.addAttribute("blog",blog);
        model.addAttribute("typeId",blog.getType().getId());
        return INPUT;
    }

    public String getTagsString(List<Tag> tags){
        if(tags==null){
            return null;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<tags.size();i++){
            sb.append(tags.get(i).getId());
            if(i!=tags.size()-1){
                sb.append(",");
            }
        }
        return sb.toString();
    }


}
