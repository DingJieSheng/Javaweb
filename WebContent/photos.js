/**
 * Created by ac on 2017/5/21.
 */
$(document).ready(function () {
    var r=0;
    $("div").bind("click",function () {
        r+=60;
        $("#container").css("transform","rotateY("+r+"deg)").css("transition","1s");
        var reg=/photo.*jpg/;
        var path=reg.exec(this.getAttribute("style"))
        $("body").css("background","url(res/"+path+")").css("transition","opcity(0)").css("transition","1s");
        return false;
    })
})