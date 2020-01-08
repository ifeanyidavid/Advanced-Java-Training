/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refactored;

/**
 *
 * @author dkalu
 */
public class DiHandlerMain {
    public static void main(String[] args) {
        DIHandler handler = new DIHandler(new ErrorLogger());
        handler.CreatePost(new Database(), "New Post");
    }
}
