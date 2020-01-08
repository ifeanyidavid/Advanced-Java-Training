/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refactored;


import java.util.ArrayList;
import java.util.List;

class Database {

    void Add(String postMessage) {
        System.out.println("Adding Post");
    }

    void AddAsTag(String postMessage) {
         System.out.println("Adding Tag Post");
    }

    void NotifyUser(String user) {
        System.out.println("Notify User...");
    }

    void OverrideExistingMention(String user, String postMessage) {
        System.out.println("Override mention");
    }

    List<Post> getUnhandledPostsMessages() {
        System.out.println("Getting unhandled post messages...");
//        Post post = new Post();
        Post tagPost = new TagPost();
        Post mentionPost = new MentionPost();
        List<Post> list = new ArrayList<>();
        list.add(tagPost);
        list.add(mentionPost);
        return list;
    }

    String parseUser() {
        System.out.println("Parsing User");
        return "";
    }
}

/**
 *
 * @author dkalu
 */

interface IPost{
    void CreatePost(Database db, String postMessage);
}

class Post implements IPost
{
    @Override
    public void CreatePost(Database db, String postMessage) {
        db.Add(postMessage);
    }
}

interface ITagPost{
    void CreateTagPost(Database db, String postMessage);
}

class TagPost extends Post implements ITagPost
{
    @Override
    public void CreatePost(Database db, String postMessage) {
        db.AddAsTag(postMessage);
    }

    @Override
    public void CreateTagPost(Database db, String postMessage) {
//        Handle # post implementation
    }
    
}

interface IMentionPost{
    void CreateMentionPost(Database db, String postMessage);
}

class MentionPost extends Post implements IMentionPost
{
    @Override
    public void CreatePost(Database db, String postMessage) {
        CreateMentionPost(db, postMessage);
    }
    
    @Override
    public void CreateMentionPost(Database db, String postMessage){
        String user = db.parseUser();
        db.NotifyUser(user);
        db.OverrideExistingMention(user, postMessage);
        super.CreatePost(db, postMessage);
    }   
}

class PostHandlerFactory{
    public IPost getPostType(String postMessage){
        if(postMessage.startsWith("#")){
            return new TagPost();
        }
        if(postMessage.startsWith("@")){
            return new MentionPost();
        }
        return new Post();
    }
}

class PostHandler
{
    private final Database database = new Database();

    void HandleNewPosts() {
        
        List<Post> posts = database.getUnhandledPostsMessages();
        String postMessage = "#Dave";

        for (Post post : posts)
        {   
            post.CreatePost(database, postMessage);
        }
    }
    
    public static void main(String[] args) {
        PostHandler handler = new PostHandler();
        handler.HandleNewPosts();
    }
}