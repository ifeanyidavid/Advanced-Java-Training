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
public class DIHandler {
    
    private static Logger logger;
    
    public DIHandler(Logger logger){
        this.logger = logger;
    }

    static void CreatePost(Database db, String postMessage) {
        try {
            db.Add(postMessage);
        } catch (Exception ex) {
            logger.log(ex.getMessage());
        }
    }
}