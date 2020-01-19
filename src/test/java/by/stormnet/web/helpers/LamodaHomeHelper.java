package by.stormnet.web.helpers;

import by.stormnet.web.pages.LamodaHomePage;

public class LamodaHomeHelper extends AbsractHelper {
    LamodaHomePage lamodaHomePage = new LamodaHomePage();

    public LamodaHomeHelper openLamodaHomeHelper() {
        lamodaHomePage.navigateToLamodaHomePage();
        return this;
    }

    public LamodaHomeHelper LogInToAccount(String LamodaEmail, String LamodaPassword) {
        lamodaHomePage.clickEnterBtn().fillEmailField(LamodaEmail).fillPassField(LamodaPassword).clickSubmit();
        return this;
    }

}