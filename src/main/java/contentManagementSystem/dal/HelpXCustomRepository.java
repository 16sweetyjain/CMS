package contentManagementSystem.dal;

import contentManagementSystem.model.Faq;
import contentManagementSystem.model.HelpX;

import java.util.List;

public interface HelpXCustomRepository {
    public List<HelpX> getAllHelpXArticle();
    public HelpX getHelpXArticle(String id);
    public HelpX addHelpXArticle(HelpX helpX);
    public HelpX updateHelpXArticle(HelpX helpX, String helpxId);
}
