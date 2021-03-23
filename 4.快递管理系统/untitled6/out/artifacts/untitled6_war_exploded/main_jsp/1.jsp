<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <title>区域管理页面</title>

    <link href="../css/bootstrap.min.css" rel="stylesheet" >
    <!-- Custom styles for this template -->
    <link href="../css/dashboard.css" rel="stylesheet">

    <!-- font awesome css-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">

    <!-- boostrap-table css-->
    <link href="../bootstrap-table/bootstrap-table.min.css">

</head>
<body>






    <!-- 右边的主体部分 -->
    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
        <h2>区域管理</h2>
        <!--写一个table bootstrap-table-->
        <!-- toolbar  -->
        <div class="panel panel-primary">
            <div class="panel-body">
                <div id="toolbar" >
                    <form class="form-inline" style="width:100%; margin-bottom: 20px;">
                        <div class="form-group" style="margin-left: 5px;">
                            <input type="button" value="新增区域" id="addBtn" data-toggle="modal" data-target="#addAreaModal" class="btn btn-primary" >
                        </div>
                        <div class="form-group" style="margin-left: 5px;">
                            <input type="button" value="删除区域" id="deleteBtn" class="btn btn-info" onclick="deleteArea()">
                        </div>
                        <div class="form-group" style="margin-left: 5px;">
                            <input type="button" value="修改区域" id="editBtn" class="btn btn-danger" onclick="editArea()">
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
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="resetForm()"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">区域信息</h4>
                    </div>
                    <div class="modal-body">

                        <form id="addAreaForm" class="form-horizontal" action="area/add"  method="post">
                            <input type="hidden" name ="id" id="areaId">
                            <div class="form-group">
                                <label for="buildingName" class="col-sm-2 control-label">楼栋名称：</label>
                                <div class="col-sm-10">
                                    <input type="text" name="buildingName" id="buildingName" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="floor" class="col-sm-2 control-label">楼层：</label>
                                <div class="col-sm-10">
                                    <input type="text" name="floor" id="floor" class="form-control">
                                </div>
                            </div>

                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="resetForm()">取消</button>
                        <button type="button" class="btn btn-primary" onclick="addArea()">确定</button>
                    </div>
                </div>
            </div>
        </div>
    </main>
</div>
<!--jquery slim 版本-->
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.bundle.min.js"></script>


<!-- 引入 bootstrap-table js -->
<script type="text/javascript" src="../bootstrap-table/bootstrap-table.min.js"></script>
<script type="text/javascript" src="../bootstrap-table/bootstrap-table-zh-CN.min.js"></script>
<!--font awesome-->
<script src="https://cdn.bootcss.com/font-awesome/5.8.1/js/all.min.js"></script>
<script>
    function queryArea() {
        $('#table').bootstrapTable('refresh');
    }
    $('#table').bootstrapTable({
        url: 'data1.json',
        pagination: true,
        pageNumber:1,                       //初始化加载第一页，默认第一页
        pageSize: 5,                       //每页的记录行数（*）
        pageList: [5, 10, 25],        //可供选择的每页的行数（*）
        columns: [{
            field:"state",
            checkbox:"true"
        },{
            field: 'id',
            title: 'ID'
        }, {
            field: 'building',
            title: '楼栋'
        }, {
            field: 'floor',
            title: '楼层'
        }]
    });
</script>
</body>
</html>