<%@ page import="mysql.Accountmysql" %>
<%--
  Created by IntelliJ IDEA.
  User: Ryota
  Date: 2020/6/16
  Time: 8:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>inspinia 2.9.2 | 主页</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">

    <!-- Toastr style -->
    <link href="css/plugins/toastr/toastr.min.css" rel="stylesheet">

    <!-- Gritter -->
    <link href="js/plugins/gritter/jquery.gritter.css" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">


</head>

<body>
<div id="wrapper">
    <jsp:include page="菜单.jsp">
        <jsp:param name="asd" value="asd"/>
    </jsp:include>
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
                    <form role="search" class="navbar-form-custom" action="search_results.html">
                        <div class="form-group">
                            <input type="text" placeholder="请输入搜索内容" class="form-control" name="top-search" id="top-search">
                        </div>
                    </form>
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li style="padding: 20px">
                        <span class="m-r-sm text-muted welcome-message">欢迎来到inspinia 2.9.2管理后台</span>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                            <i class="fa fa-envelope"></i>  <span class="label label-warning">16</span>
                        </a>
                        <ul class="dropdown-menu dropdown-messages dropdown-menu-right">
                            <li>
                                <div class="dropdown-messages-box">
                                    <a class="dropdown-item float-left" href="profile.html">
                                        <img alt="image" class="rounded-circle" src="img/a7.jpg">
                                    </a>
                                    <div class="media-body">
                                        <small class="float-right">46 小时前</small>
                                        <strong>小明</strong> 评论了 <strong>小红</strong>. <br>
                                        <small class="text-muted">2017.10.06 7:58</small>
                                    </div>
                                </div>
                            </li>
                            <li class="dropdown-divider"></li>
                            <li>
                                <div class="dropdown-messages-box">
                                    <a class="dropdown-item float-left" href="profile.html">
                                        <img alt="image" class="rounded-circle" src="img/a4.jpg">
                                    </a>
                                    <div class="media-body ">
                                        <small class="float-right text-navy">5 小时前</small>
                                        <strong>小红</strong> 打电话给了 <strong>小黑</strong>. <br>
                                        <small class="text-muted">2017.10.06 7:58</small>
                                    </div>
                                </div>
                            </li>
                            <li class="dropdown-divider"></li>
                            <li>
                                <div class="dropdown-messages-box">
                                    <a class="dropdown-item float-left" href="profile.html">
                                        <img alt="image" class="rounded-circle" src="img/profile.jpg">
                                    </a>
                                    <div class="media-body ">
                                        <small class="float-right">23 小时前</small>
                                        <strong>小黑</strong> 点赞了 <strong>小红</strong>. <br>
                                        <small class="text-muted">2017.10.06 7:58</small>
                                    </div>
                                </div>
                            </li>
                            <li class="dropdown-divider"></li>
                            <li>
                                <div class="text-center link-block">
                                    <a href="mailbox.html" class="dropdown-item">
                                        <i class="fa fa-envelope"></i> <strong>阅读所有消息</strong>
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                            <i class="fa fa-bell"></i>  <span class="label label-primary">8</span>
                        </a>
                        <ul class="dropdown-menu dropdown-alerts">
                            <li>
                                <a href="mailbox.html" class="dropdown-item">
                                    <div>
                                        <i class="fa fa-envelope fa-fw"></i> 你有16条消息
                                        <span class="float-right text-muted small">4 分钟前</span>
                                    </div>
                                </a>
                            </li>
                            <li class="dropdown-divider"></li>
                            <li>
                                <a href="profile.html" class="dropdown-item">
                                    <div>
                                        <i class="fa fa-twitter fa-fw"></i> 3 个新的关注者
                                        <span class="float-right text-muted small">12 分钟前</span>
                                    </div>
                                </a>
                            </li>
                            <li class="dropdown-divider"></li>
                            <li>
                                <a href="grid_options.html" class="dropdown-item">
                                    <div>
                                        <i class="fa fa-upload fa-fw"></i> 重启服务器
                                        <span class="float-right text-muted small">4 分钟前</span>
                                    </div>
                                </a>
                            </li>
                            <li class="dropdown-divider"></li>
                            <li>
                                <div class="text-center link-block">
                                    <a href="notifications.html" class="dropdown-item">
                                        <strong>查看所有信息</strong>
                                        <i class="fa fa-angle-right"></i>
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </li>


                    <li>
                        <a href="login.html">
                            <i class="fa fa-sign-out"></i> 注销
                        </a>
                    </li>

                </ul>

            </nav>
        </div>
        <div class="row  border-bottom white-bg dashboard-header">

            <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">

                <div class="panel panel-primary">
                    <div class="panel-body">
                        <div id="toolbar" >
                            <form class="form-inline" style="width:100%; margin-bottom: 20px;">
                                <div class="form-group" style="margin-left: 5px;">
                                    <input type="button" value="新增快递" id="addBtn" data-toggle="modal" data-target="#addAreaModal" class="btn btn-primary" >
                                </div>
                                <div class="form-group" style="margin-left: 5px;">
                                    <input type="button" value="删除快递" id="deleteBtn" class="btn btn-info" onclick="deleteArea()">
                                </div>
                                <div class="form-group" style="margin-left: 5px;">
                                    <input type="button" value="修改信息" id="editBtn" class="btn btn-danger" onclick="editArea()">
                                </div>
                                <div class="form-group" style="margin-left: 5px;">
                                    <label for="queryName"></label>
                                    <input type="text" id="queryName" class="form-control">
                                    <input type="button" class="btn btn-success" id="queryBtn"  value="查询" onclick="queryArea()">
                                </div>
                            </form>

                        </div>
                        <div class="container" style="width:100%;margin-top: 20px;">
                            <!--放一个table元素-->
                            <table id="table"></table>

                        </div>
                    </div>
                </div>

                <!-- 新增区域模态窗体 -->
                <div class="modal fade" id="addAreaModal" role="dialog" tabindex="-1">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header ">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="reset_Form()"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">快递信息</h4>
                            </div>
                            <div class="modal-body">
                                <form id="addAreaForm" class="form-horizontal" action="../editlist" method="post">
                                    <input type="hidden" name="id" id="areaId">
                                    <div class="row">
                                        <div class="form-group">
                                            <label for="sender" class="col-md-8 control-label">寄件人</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="sender" id="sender" class="form-control">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="telephone" class="col-md-8 control-label">电话</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="telephone" id="telephone" class="form-control">
                                            </div>
                                        </div>
                                    </div>


                                    <div class="row">
                                        <div class="form-group">
                                            <label for="company" class="col-md-8 control-label">公司</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="company" id="company" class="form-control">
                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <label for="ramarks" class="col-md-8 control-label">备注</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="ramarks" id="ramarks" class="form-control">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group">
                                            <label for="address" class="col-md-8 control-label">收货地</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="address" id="address" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="addressee" class="col-md-8 control-label">收货人</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="address" id="addressee" class="form-control">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="imageurl" class="col-md-8 control-label">图片</label>
                                        <div class="col-sm-10">
                                            <img id="image" name="image" class="cover-radius" src="../js/upload_img.png" width="100%" style="cursor: pointer;"/>
                                            <input id="imageurl" name="imageurl" type="file" style="cursor: pointer;" onchange="upload_cover(this)"/>
                                            <small class="help-block cover-tips" style="cursor: pointer;" >请上传照片</small>
                                        </div>
                                    </div>

                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal" onclick="reset_Form()">取消</button>
                                <button type="button" class="btn btn-primary" onclick="addinfo()">确定</button>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
        </div>

    </div>
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" src="../bootstrap-table/bootstrap-table.min.js"></script>
    <script type="text/javascript" src="../bootstrap-table/bootstrap-table-zh-CN.min.js"></script>
    <!--font awesome-->
    <script src="https://cdn.bootcss.com/font-awesome/5.8.1/js/all.min.js"></script>
        <script>
            <%--    图片上传--%>
            function upload_cover(obj) {
                // 调用 另外一个函数，请求ajax成功后，的一个匿名回调函数
                ajax_upload(obj.id, function (data) {
                    //function(data)是上传图片的成功后的回调方法
                    // console.log("回调函数");
                    // console.log(data);
                    var basePath = '..';
                    //获取的图片的绝对路径
                    console.log(data.realatPath);
                    var isrc = data.realatPath;
                    var imgSrc = basePath + isrc;

                    //给<input>的src赋值去显示图片
                    imgs=imgSrc;
                    console.log(imgSrc)
                    $('#image').attr('src', basePath + isrc).data('img-src', isrc);
                });
            }
            function ajax_upload(feid, callback) { //具体的上传图片方法
                if (image_check(feid)) { //自己添加的文件后缀名的验证
                    console.log(feid);
                    $.ajaxFileUpload({
                        fileElementId: feid,    //需要上传的文件域的ID，即<input type="file">的ID。
                        url: '../upload', //后台方法的路径
                        type: 'post',   //当要提交自定义参数时，这个参数要设置成post
                        dataType: 'json',   //服务器返回的数据类型。可以为xml,script,json,html。如果不填写，jQuery会自动判断。
                        secureuri: false,   //是否启用安全提交，默认为false。
                        async : true,   //是否是异步
                        success: function(data) {   //提交成功后自动执行的处理函数，参数data就是服务器返回的数据。
                            console.log("函数是否执行成功")
                            if (callback) callback.call(this, data);
                        },
                        error: function(data, status, e) {  //提交失败自动执行的处理函数。
                            console.error(e);
                        }
                    });
                }
            }
            function image_check(feid) { //自己添加的文件后缀名的验证
                var img = document.getElementById(feid);
                return /.(jpg|png|gif|bmp)$/.test(img.value)?true:(function() {
                    alert('图片格式仅支持jpg、png、gif、bmp格式，且区分大小写。');
                    return false;
                })();
            }
        </script>
    <script>

        function queryArea() {
            $('#table').bootstrapTable('refresh');
        };
        function queryParam(params){

            var param = {
                name:<%out.print(request.getSession().getAttribute("name"));%>,
                queryName:$("#queryName").val(),
                limit : params.limit, // 数据集合大小
                offset : params.offset, // 页码
                pageIndex : this.pageNumber,
                pageSize : this.pageSize
            };

            return param;

        }
        $('#table').bootstrapTable({
            contentType : "application/x-www-form-urlencoded",
            queryParams:queryParam,
            url: '../getdata',
            method:"GET",
            dataType:"json",
            pagination: true,
            sidePagination: "server", //server表示服务端分页，client客户端分页
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 5,                       //每页的记录行数（*）
            pageList: [5, 25],        //可供选择的每页的行数（*）
            uniqueId: "id",
            striped: true,
            singleSelect:true,
            clickToSelect:true,
            showRefresh:true,
            showToggle:true,
            toolbar:"#toolbar",
            columns: [{
                field:"state",
                checkbox:"true"
            },{
                field: 'id',
                title: 'ID',
                visible:false
            }, {
                field: 'waybill',
                title: '单号'
            }, {
                field:'sender',
                title:'寄件人'
            },
                {
                field: 'addressee',
                title: '收件人'
            },{
              field:'recetime',
                title:'签收日期'
            },
                {
                    field: 'company',
                    title: '公司'
                }, {
                    field: 'telephone',
                    title: '电话'
                }, {
                    field: 'address',
                    title: '地点'
                },{
                    field:"remarks",
                    title:"备注"
                }, {
                    field: 'picture',
                    title: '图片',
                    detailView: true,
                    formatter: function (value, row, index) {
                        if (value != '') {
                            console.log(row);
                            var image = '<div class="photos">'
                                + '<a target="_blank" >'
                                + '<img alt="image" style="width: 120px;height: 50px;margin: auto" class="feed-photo"'
                                + ' src="' + row['picture'] + '"></a>'
                                + '</div>';
                            return image;
                        } else {
                            return '';
                        }

                    }
                }]
        });
        var imgs;
        function addinfo() {

            var uname=<%out.print(request.getSession().getAttribute("name"));;%>;
            var imageurl=imgs;
            var telephone=$("#telephone").val();
            var company=$("#company").val();
            var ramark=$("#ramarks").val();
            var url="../Addlist";
            var sender=$("#sender").val();
            var address=$("#address").val();
            var addressee=$("#addressee").val();
            $.ajax({
                url:url,
                data:{"name":uname,"remarks":ramark,"image":imageurl,"tel":telephone,"company":company,"sender":sender,"address":address,"addressee":addressee},
                method:"get",
                dataType:"json",
                success:function (result) {
                    if(result.status="success"){
                        toastr.success("加入完成")
                    }else{
                        toastr.success("wtf？？？")
                    }
                    //隐藏框
                    $("#addAreaModal").modal("hide");
                    reset_Form();
                },
                timeout:5000,
                error:function (error) {
                    toastr.success("服务器失败",error)
                }
            })
            $('#table').bootstrapTable('refresh');
        };
        function reset_Form() {
            $("#addAreaForm").find('input[type=text],input[tpye=hindden]').each(function () {
                $(this).val('')
            })
            $("#addAreaForm").find('input[type=image],input[tpye=hindden]').each(function () {
                $(this).val('')
            })
        };
        function editArea() {
            //获取行数
            var rows =$('#table').bootstrapTable('getSelections');
            if(rows.length==0){
                toastr.success("啥都没选")
                return;
            }
            var currentrow=rows[0];
            //给框值
            console.log(currentrow);
            $("#areaId").val(currentrow.id)
            $("#ramarks").val(currentrow.remarks)
            $("#addressee").val(currentrow.addressee)
            $("#telephone").val(currentrow.telephone)
            $("#company").val(currentrow.company)
            $("#address").val(currentrow.address)
            $("#sender").val(currentrow.sender)
            //显示
            $("#addAreaModal").modal("show");
        }
    </script>
    <!-- Mainly scripts -->
     <script src="js/ajaxfileupload.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="js/plugins/flot/jquery.flot.js"></script>
    <script src="js/plugins/flot/jquery.flot.tooltip.min.js"></script>
    <script src="js/plugins/flot/jquery.flot.spline.js"></script>
    <script src="js/plugins/flot/jquery.flot.resize.js"></script>
    <script src="js/plugins/flot/jquery.flot.pie.js"></script>

    <!-- Peity -->
    <script src="js/plugins/peity/jquery.peity.min.js"></script>
    <script src="js/demo/peity-demo.js"></script>>
    <script src="js/inspinia.js"></script>
    <script src="js/plugins/pace/pace.min.js"></script>
    <script src="js/plugins/jquery-ui/jquery-ui.min.js"></script>
    <script src="js/plugins/gritter/jquery.gritter.min.js"></script>
    <script src="js/plugins/sparkline/jquery.sparkline.min.js"></script>
    <script src="js/demo/sparkline-demo.js"></script>
    <script src="js/plugins/chartJs/Chart.min.js"></script>
    <script src="js/plugins/toastr/toastr.min.js"></script>
    <script>
        $(document).ready(function () {
            setTimeout(function () {
                toastr.options = {
                    closeButton: true,
                    progressBar: true,
                    showMethod: 'slideDown',
                    timeOut: 4000
                };
                toastr.success(<%out.print(request.getSession().getAttribute("name"));%>, '嘿嘿 来了熬');

            }, 1300);


            var data1 = [
                [0, 4], [1, 8], [2, 5], [3, 10], [4, 4], [5, 16], [6, 5], [7, 11], [8, 6], [9, 11], [10, 30], [11, 10], [12, 13], [13, 4], [14, 3], [15, 3], [16, 6]
            ];
            var data2 = [
                [0, 1], [1, 0], [2, 2], [3, 0], [4, 1], [5, 3], [6, 1], [7, 5], [8, 2], [9, 3], [10, 2], [11, 1], [12, 0], [13, 2], [14, 8], [15, 0], [16, 0]
            ];
            $("#flot-dashboard-chart").length && $.plot($("#flot-dashboard-chart"), [
                    data1, data2
                ],
                {
                    series: {
                        lines: {
                            show: false,
                            fill: true
                        },
                        splines: {
                            show: true,
                            tension: 0.4,
                            lineWidth: 1,
                            fill: 0.4
                        },
                        points: {
                            radius: 0,
                            show: true
                        },
                        shadowSize: 2
                    },
                    grid: {
                        hoverable: true,
                        clickable: true,
                        tickColor: "#d5d5d5",
                        borderWidth: 1,
                        color: '#d5d5d5'
                    },
                    colors: ["#1ab394", "#1C84C6"],
                    xaxis: {
                    },
                    yaxis: {
                        ticks: 4
                    },
                    tooltip: false
                }
            );

            var doughnutData = {
                labels: ["App", "Software", "Laptop"],
                datasets: [{
                    data: [300, 50, 100],
                    backgroundColor: ["#a3e1d4", "#dedede", "#9CC3DA"]
                }]
            };


            var doughnutOptions = {
                responsive: false,
                legend: {
                    display: false
                }
            };

            var ctx4 = document.getElementById("doughnutChart").getContext("2d");
            new Chart(ctx4, { type: 'doughnut', data: doughnutData, options: doughnutOptions });
            var doughnutData = {
                labels: ["App", "Software", "Laptop"],
                datasets: [{
                    data: [70, 27, 85],
                    backgroundColor: ["#a3e1d4", "#dedede", "#9CC3DA"]
                }]
            };
            var doughnutOptions = {
                responsive: false,
                legend: {
                    display: false
                }
            };
            var ctx4 = document.getElementById("doughnutChart2").getContext("2d");
            new Chart(ctx4, { type: 'doughnut', data: doughnutData, options: doughnutOptions });
        });
    </script>
    <script>
        (function (i, s, o, g, r, a, m) {
            i['GoogleAnalyticsObject'] = r; i[r] = i[r] || function () {
                (i[r].q = i[r].q || []).push(arguments)
            }, i[r].l = 1 * new Date(); a = s.createElement(o),
                m = s.getElementsByTagName(o)[0]; a.async = 1; a.src = g; m.parentNode.insertBefore(a, m)
        })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');

        ga('create', 'UA-4625583-2', 'webapplayers.com');
        ga('send', 'pageview');

    </script>
    <script>
        // Config box

        // Enable/disable fixed top navbar
        $('#fixednavbar').click(function () {
            if ($('#fixednavbar').is(':checked')) {
                $(".navbar-static-top").removeClass('navbar-static-top').addClass('navbar-fixed-top');
                $("body").removeClass('boxed-layout');
                $("body").addClass('fixed-nav');
                $('#boxedlayout').prop('checked', false);

                if (localStorageSupport) {
                    localStorage.setItem("boxedlayout", 'off');
                }

                if (localStorageSupport) {
                    localStorage.setItem("fixednavbar", 'on');
                }
            } else {
                $(".navbar-fixed-top").removeClass('navbar-fixed-top').addClass('navbar-static-top');
                $("body").removeClass('fixed-nav');
                $("body").removeClass('fixed-nav-basic');
                $('#fixednavbar2').prop('checked', false);

                if (localStorageSupport) {
                    localStorage.setItem("fixednavbar", 'off');
                }

                if (localStorageSupport) {
                    localStorage.setItem("fixednavbar2", 'off');
                }
            }
        });

        // Enable/disable fixed top navbar
        $('#fixednavbar2').click(function () {
            if ($('#fixednavbar2').is(':checked')) {
                $(".navbar-static-top").removeClass('navbar-static-top').addClass('navbar-fixed-top');
                $("body").removeClass('boxed-layout');
                $("body").addClass('fixed-nav').addClass('fixed-nav-basic');
                $('#boxedlayout').prop('checked', false);

                if (localStorageSupport) {
                    localStorage.setItem("boxedlayout", 'off');
                }

                if (localStorageSupport) {
                    localStorage.setItem("fixednavbar2", 'on');
                }
            } else {
                $(".navbar-fixed-top").removeClass('navbar-fixed-top').addClass('navbar-static-top');
                $("body").removeClass('fixed-nav').removeClass('fixed-nav-basic');
                $('#fixednavbar').prop('checked', false);

                if (localStorageSupport) {
                    localStorage.setItem("fixednavbar2", 'off');
                }
                if (localStorageSupport) {
                    localStorage.setItem("fixednavbar", 'off');
                }
            }
        });

        // Enable/disable fixed sidebar
        $('#fixedsidebar').click(function () {
            if ($('#fixedsidebar').is(':checked')) {
                $("body").addClass('fixed-sidebar');
                $('.sidebar-collapse').slimScroll({
                    height: '100%',
                    railOpacity: 0.9
                });

                if (localStorageSupport) {
                    localStorage.setItem("fixedsidebar", 'on');
                }
            } else {
                $('.sidebar-collapse').slimscroll({ destroy: true });
                $('.sidebar-collapse').attr('style', '');
                $("body").removeClass('fixed-sidebar');

                if (localStorageSupport) {
                    localStorage.setItem("fixedsidebar", 'off');
                }
            }
        });

        // Enable/disable collapse menu
        $('#collapsemenu').click(function () {
            if ($('#collapsemenu').is(':checked')) {
                $("body").addClass('mini-navbar');
                SmoothlyMenu();

                if (localStorageSupport) {
                    localStorage.setItem("collapse_menu", 'on');
                }

            } else {
                $("body").removeClass('mini-navbar');
                SmoothlyMenu();

                if (localStorageSupport) {
                    localStorage.setItem("collapse_menu", 'off');
                }
            }
        });

        // Enable/disable boxed layout
        $('#boxedlayout').click(function () {
            if ($('#boxedlayout').is(':checked')) {
                $("body").addClass('boxed-layout');
                $('#fixednavbar').prop('checked', false);
                $('#fixednavbar2').prop('checked', false);
                $(".navbar-fixed-top").removeClass('navbar-fixed-top').addClass('navbar-static-top');
                $("body").removeClass('fixed-nav');
                $("body").removeClass('fixed-nav-basic');
                $(".footer").removeClass('fixed');
                $('#fixedfooter').prop('checked', false);

                if (localStorageSupport) {
                    localStorage.setItem("fixednavbar", 'off');
                }

                if (localStorageSupport) {
                    localStorage.setItem("fixednavbar2", 'off');
                }

                if (localStorageSupport) {
                    localStorage.setItem("fixedfooter", 'off');
                }


                if (localStorageSupport) {
                    localStorage.setItem("boxedlayout", 'on');
                }
            } else {
                $("body").removeClass('boxed-layout');

                if (localStorageSupport) {
                    localStorage.setItem("boxedlayout", 'off');
                }
            }
        });

        // Enable/disable fixed footer
        $('#fixedfooter').click(function () {
            if ($('#fixedfooter').is(':checked')) {
                $('#boxedlayout').prop('checked', false);
                $("body").removeClass('boxed-layout');
                $(".footer").addClass('fixed');

                if (localStorageSupport) {
                    localStorage.setItem("boxedlayout", 'off');
                }

                if (localStorageSupport) {
                    localStorage.setItem("fixedfooter", 'on');
                }
            } else {
                $(".footer").removeClass('fixed');

                if (localStorageSupport) {
                    localStorage.setItem("fixedfooter", 'off');
                }
            }
        });

        // SKIN Select
        $('.spin-icon').click(function () {
            $(".theme-config-box").toggleClass("show");
        });

        // Default skin
        $('.s-skin-0').click(function () {
            $("body").removeClass("skin-1");
            $("body").removeClass("skin-2");
            $("body").removeClass("skin-3");
        });

        // Blue skin
        $('.s-skin-1').click(function () {
            $("body").removeClass("skin-2");
            $("body").removeClass("skin-3");
            $("body").addClass("skin-1");
        });

        // Inspinia ultra skin
        $('.s-skin-2').click(function () {
            $("body").removeClass("skin-1");
            $("body").removeClass("skin-3");
            $("body").addClass("skin-2");
        });

        // Yellow skin
        $('.s-skin-3').click(function () {
            $("body").removeClass("skin-1");
            $("body").removeClass("skin-2");
            $("body").addClass("skin-3");
        });

        if (localStorageSupport) {
            var collapse = localStorage.getItem("collapse_menu");
            var fixedsidebar = localStorage.getItem("fixedsidebar");
            var fixednavbar = localStorage.getItem("fixednavbar");
            var fixednavbar2 = localStorage.getItem("fixednavbar2");
            var boxedlayout = localStorage.getItem("boxedlayout");
            var fixedfooter = localStorage.getItem("fixedfooter");

            if (collapse == 'on') {
                $('#collapsemenu').prop('checked', 'checked')
            }
            if (fixedsidebar == 'on') {
                $('#fixedsidebar').prop('checked', 'checked')
            }
            if (fixednavbar == 'on') {
                $('#fixednavbar').prop('checked', 'checked')
            }
            if (fixednavbar2 == 'on') {
                $('#fixednavbar2').prop('checked', 'checked')
            }
            if (boxedlayout == 'on') {
                $('#boxedlayout').prop('checked', 'checked')
            }
            if (fixedfooter == 'on') {
                $('#fixedfooter').prop('checked', 'checked')
            }
        }
    </script>
</body>
</html>
