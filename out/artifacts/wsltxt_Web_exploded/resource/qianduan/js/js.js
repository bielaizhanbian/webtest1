/*������ҳ����ʼ*/

$("tbody").attr("id", "allitems");
$("tr").attr("class", "oneitem");
var tablesave = $("#allitems").html();
tablesave = "<tbody id='allitems'>" + tablesave + "</tbody>"
var search = "";

var currentPage = 1;

function goTablePage(pno, psize) {

    search = $("#search").val();


    var numall = $("#allitems .oneitem").length;

    for (var i = 0; i < numall; i++) {
        $("#allitems .oneitem")[i].style.display = "table-row";
    }

    var scindex = [];
    for (var i = 1; i < (numall + 1); i++) {
        if ($("#allitems .oneitem")[i - 1].innerText.indexOf(search) == -1 && search) {
            scindex.push(i - 1);
        }
    }

    for (var i = scindex.length - 1; i >= 0; i--) {
        $("#allitems .oneitem")[scindex[i]].style.display = "none";
        // $("#allitems .oneitem")[scindex[i]].remove();
    }

    var num = $("#allitems .oneitem[style='display: table-row;']").length;

    // alert(num);

    var totalPage = 0;//��ҳ��
    var pageSize = psize;//ÿҳ��ʾ����
    //�ܹ��ּ�ҳ
    if (num / pageSize > parseInt(num / pageSize)) {
        totalPage = parseInt(num / pageSize) + 1;
    } else {
        totalPage = parseInt(num / pageSize);
    }
    var currentPage = pno;//��ǰҳ��
    var startRow = (currentPage - 1) * pageSize + 1;//��ʼ��ʾ���� 31
    var endRow = currentPage * pageSize;//������ʾ����  40
    endRow = (endRow > num) ? num : endRow;  //40
    //������ʾ����ʵ�ַ�ҳ

    var displayindex = [];
    var j = 0;
    for (var i = 0; i < numall; i++) {

        var tritemdisplay = $("#allitems .oneitem")[i].style.display;
        console.log(tritemdisplay);
        console.log(tritemdisplay.indexOf("table-row") >= 0);
        if (tritemdisplay.indexOf("table-row") >= 0) {
            j++;
        }
        if (j < startRow || j > endRow) {
            displayindex.push(i);
        }
    }

    console.log(j)
    console.log(startRow)
    console.log(endRow)
    console.log(displayindex)

    for (var i = displayindex.length - 1; i >= 0; i--) {
        $("#allitems .oneitem")[displayindex[i]].style.display = "none";
    }


    var tempStr1 = "��" + num + "����¼ ��" + totalPage + "ҳ ��ǰ��" + currentPage + "ҳ";

    var tempStr2 = "";


    $("#shangyiye").off("click");
    $("#shangyiye").click(function () {
        goTablePage(currentPage - 1, psize)
    });

    $("#xiayiye").off("click");
    $("#xiayiye").click(function () {
        goTablePage(currentPage + 1, psize)
    });

    if (currentPage > 1) {

        $("#shangyiye").off("click");
        $("#shangyiye").click(function () {
            goTablePage(currentPage - 1, psize)
        });


        //��һҳ��ť
        tempStr2 += "<a href=\"javascript:;;\" onClick=\"goTablePage(" + (1) + "," + psize + ")\"  style=\"margin-left: 10px;\"><i class=\"fa fa-angle-left\"></i><i class=\"fa fa-angle-left\"></i></a>";
        //��һҳ��ť
        tempStr2 += "<a href=\"javascript:;;\" onClick=\"goTablePage(" + (currentPage - 1) + "," + psize + ")\"  style=\"margin-left: 10px;\"><i class=\"fa fa-angle-left\"></i></a>";
        //��ǰҳ
        tempStr2 += "<a style=\"background-color: #6eb7e2;color: #fff;border: none;padding: 0.3rem 0.7rem;background-image: -webkit-linear-gradient(left,#6eb7e2,#6eb7e2);margin-left: 10px;\">" + currentPage + "</a>";
    } else {

        $("#shangyiye").off("click");

        //��һҳ��ť
        tempStr2 += "<a href=\"javascript:;;\"  style=\"margin-left: 10px;\"><i class=\"fa fa-angle-left\"></i><i class=\"fa fa-angle-left\"></i></a>";
        //��һҳ��ť
        tempStr2 += "<a href=\"javascript:;;\"  style=\"margin-left: 10px;\"><i class=\"fa fa-angle-left\"></i></a>";
        //��ǰҳ
        tempStr2 += "<a style=\"background-color: #6eb7e2;color: #fff;border: none;padding: 0.3rem 0.7rem;background-image: -webkit-linear-gradient(left,#6eb7e2,#6eb7e2);margin-left: 10px;\">" + currentPage + "</a>";
    }
    if (currentPage < totalPage) {

        $("#xiayiye").off("click");
        $("#xiayiye").click(function () {
            goTablePage(currentPage + 1, psize)
        });

        //��һҳ
        tempStr2 += "<a href=\"javascript:;;\" onClick=\"goTablePage(" + (currentPage + 1) + "," + psize + ")\"  style=\"margin-left: 10px;\"><i class=\"fa fa-angle-right\"></i></a>";
        //���ҳ
        tempStr2 += "<a href=\"javascript:;;\" onClick=\"goTablePage(" + (totalPage) + "," + psize + ")\"  style=\"margin-left: 10px;\"><i class=\"fa fa-angle-right\"></i><i class=\"fa fa-angle-right\"></i></a>";
    } else {

        $("#xiayiye").off("click");

        //��һҳ
        tempStr2 += "<a href=\"javascript:;;\" style=\"margin-left: 10px;\"><i class=\"fa fa-angle-right\"></i></a>";
        //���ҳ
        tempStr2 += "<a href=\"javascript:;;\" style=\"margin-left: 10px;\"><i class=\"fa fa-angle-right\"></i><i class=\"fa fa-angle-right\"></i></a>";
    }


    try {
        document.getElementById("tempStr1").innerHTML = tempStr1;
        document.getElementById("tempStr2").innerHTML = tempStr2;
    } catch (error) {

    }


    $("#dangqianye").html(currentPage);

    $("#searchbtn").off("click");
    $("#searchbtn").prop("type", "button");
    $("#searchbtn").click(function () {
        goTablePage(1, psize)
    });

}

/*������ҳ�������*/<!--导航栏部分开始-->
<!--导航栏部分结束-->
<!--轮播图部分开始-->
window.onload = function () {
    var index = 0;

    var slideshowBox = document.getElementById("ljnz7097-slideshow");
    var pics = slideshowBox.getElementsByTagName("img");

    var slideshowPoints = document.getElementById("ljnz7097-slideshowPoints");
    var points = slideshowPoints.getElementsByTagName("li");

    var slideshowPages = document.getElementById("ljnz7097-slideshowPage");

    var pages = slideshowPages.getElementsByTagName("img");

    var pre = pages[0];
    var next = pages[1];

    for (let i = 0; i < pics.length; i++) {
        points[i].onclick = function () {

            for (var j = 0; j < pics.length; j++) {
                points[j].className = "";
                pics[j].className = "";
            }
            pics[i].className = "show";
            this.className = "active";
            index = i;
        }
    }

    pre.onclick = function () {
        if (index == 0) {
            index = pics.length - 1;
        } else {
            index = index - 1;
        }
        for (var j = 0; j < pics.length; j++) {
            pics[j].className = "";
            points[j].className = "";
        }
        pics[index].className = "show";
        points[index].className = "active";
    }

    next.onclick = function () {
        if (index == pics.length - 1) {
            index = 0;
        } else {
            index = index + 1;
        }
        for (var j = 0; j < pics.length; j++) {
            pics[j].className = "";
            points[j].className = "";
        }
        pics[index].className = "show";
        points[index].className = "active";
    }


    var aar = document.querySelector(".center");
    var Vet = setInterval(function () {
        lunbo()
    }, 1000);
    aar.onmouseover = function () {
        clearInterval(Vet);
    }
    aar.onmouseout = function () {

        Vet = setInterval(function () {
            lunbo()
        }, 1000);

    }

    function lunbo() {
        for (var j = 0; j < pics.length; j++) {
            pics[j].className = "";
            points[j].className = ""
        }


        if (index < 4) {
            index = index + 1;
        } else {
            index = 0;
        }
        pics[index].className = "show";
        points[index].className = "active";
    }
}<!--轮播图部分结束-->
<!--图文展示部分开始-->
<!--图文展示部分结束-->
<!--文字展示部分开始-->
<!--文字展示部分结束-->
<!--底部版权部分开始-->
<!--底部版权部分结束-->
<!--面包屑部分开始-->
<!--面包屑部分结束-->
<!--搜索区部分开始-->
<!--搜索区部分结束-->
<!--分页部分开始-->
<!--分页部分结束-->
<!--图文详情部分开始-->

$('#ln9wdzz5 .product-image-list li').hover(function () {
    var url = $(this).children('img').attr('src');
    $('#ln9wdzz5 .item-selected').removeClass('item-selected');
    $(this).addClass('item-selected');
    $('#ln9wdzz5 #featured').attr('src', url);
});<!--图文详情部分结束-->
<!--评论区部分开始-->
<!--评论区部分结束-->
