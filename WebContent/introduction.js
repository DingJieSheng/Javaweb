/**
 * Created by ac on 2017/5/19.
 */
$(document).ready(function () {
    $("div[id]").addClass("class0");
    $("div[id=box0]").bind("click",function () {
        $("div[id=box1]").toggleClass("class1");
        $("div[id=box2]").toggleClass("class2");
        $("div[id=box3]").toggleClass("class3");
        $("div[id=box4]").toggleClass("class4");
        $("div[id=box5]").toggleClass("class5");
        $("div[id=box6]").toggleClass("class6");
        $("div[id=box7]").toggleClass("class7");
        $("div>div").removeClass("alpha");
        return false;
    });
    $("div[id=box1]").bind("click",function () {
        $("div>div").removeClass("alpha")
        $("div[name=introduction]").toggleClass("alpha");
        return false;
    })
    $("div[id=box2]").bind("click",function () {
        $("div>div").removeClass("alpha");
        $("div[name=history]").toggleClass("alpha");
        return false;
    })
    $("div[id=box3]").bind("click",function () {
        $("div>div").removeClass("alpha");
        $("div[name=greatman]").toggleClass("alpha");
        return false;
    })
    $("div[id=box4]").bind("click",function () {
        $("div>div").removeClass("alpha");
        $("div[name=culture]").toggleClass("alpha");
        return false;
    })
    $("div[id=box5]").bind("click",function () {
        $("div>div").removeClass("alpha");
        $("div[name=honer]").toggleClass("alpha");
        return false;
    })
    $("div[id=box6]").bind("click",function () {
        window.open("photos.html")
        return false;
    })
    
});