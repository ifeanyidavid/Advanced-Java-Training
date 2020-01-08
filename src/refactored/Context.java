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
public class Context {
    private IPosts iPosts;
    
    public Context(IPosts iPosts){
        this.iPosts = iPosts;
    }
    
    public void executeStrategy(Database db, String postMessage){
        this.iPosts.createPost(db, postMessage);
    }
}
