package by.stormnet.web.helpers;

import by.stormnet.web.pages.BlogPage;

public class BlogHelper extends AbsractHelper {
    BlogPage blogPage = new BlogPage();

    public boolean checkSalesBanner() {
        blogPage.clickBlogButton();
        blogPage.clickInstaShoping();
        return blogPage.verifyInstaPage();

    }

    public boolean checkBlogTopics(){
        blogPage.clickBlogButton();
        blogPage.clickBlogMenu();
        String[] expectedTopics = {"КРАСОТА", "МОДА", "СТИЛЬ ЖИЗНИ"};
        String[] observedTopics = blogPage.checkListOfTopics();
        int count = 0;
        for (int i = 0; i < 3; i++){
            if(expectedTopics[i].compareTo(observedTopics[i]) == 0){
                count++;
            }
        }
        if(count == 3){
            return true;
        } else {
            return false;
        }
    }

    public boolean checkBeautyTopics(){
        blogPage.clickBlogMenuBeauty();
        if(blogPage.getBeautyTopics().compareTo("Красота") == 0){
            return true;
        } else {
            return false;
        }
    }

    public boolean openAndCheckBlogItem(){
        blogPage.clickBlogButton();
        String topic = blogPage.getBlogItemTopics();
        blogPage.clickBlogItemImg();
        if(topic.compareTo(blogPage.getBlogItemTopicsAfterOpen()) == 0){
            return true;
        } else {
            return false;
        }
    }

}
