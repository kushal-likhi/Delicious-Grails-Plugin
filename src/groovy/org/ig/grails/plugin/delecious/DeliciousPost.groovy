package org.ig.grails.plugin.delecious

import del.icio.us.Delicious
import java.text.SimpleDateFormat

/**
 * Created by IntelliJ IDEA.
 * User: kushal
 * Date: 9/20/11
 * Time: 6:46 PM
 * To change this template use File | Settings | File Templates.
 */
class DeliciousPost {

    Delicious deliciousConnection

    String url = ""
    String description = ""
    String notes

    List<String> tags = []

    Date date = new Date()

    Boolean replace = false
    Boolean shared = true

    public dateInDeliciousFormat() {
        return date.format("YYYY-MM-DDThh:mm:ssZ")
    }

}
