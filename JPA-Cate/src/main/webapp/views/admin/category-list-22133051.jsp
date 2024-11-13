<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Quản lý Category</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- DataTables CSS -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css">
</head>
<body>

<div class="container mt-5">
    <h2 class="text-center mb-4">Quản lý Category</h2>

    <!-- Nút Thêm Category -->
    <div class="text-right mb-3">
        <a href="${pageContext.request.contextPath}/admin/category/add" class="btn btn-success">Thêm Category</a>
    </div>

    <!-- Bảng hiển thị danh sách Category -->
    <table id="categoryTable" class="table table-striped table-bordered" style="width:100%">
        <thead>
        <tr>
            <th>Category ID</th>
            <th>Category Name</th>
            <th>Category Code</th>
            <th>Images</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
        </thead>
    </table>
</div>

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- DataTables JS -->
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap4.min.js"></script>
<!-- Bootstrap JS -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script>
$(document).ready(function () {
    $('#categoryTable').DataTable({
        "processing": true,
        "serverSide": true,
        "ajax": {
            "url": "/JPA-Cate/admin/category",  // Đảm bảo URL này chính xác
            "type": "POST"
        },
        "pageLength": 6,  // Set the default number of entries per page
        "lengthMenu": [6, 12, 18],  // Dropdown options for entries per page
        "columns": [
            { "data": "categoryId" },
            { "data": "categoryName" },
            { "data": "categoryCode" },
            { "data": "images" },
            {
                "data": "status",
                "render": function (data, type, row) {
                    return data ? "Active" : "Inactive";
                }
            },
            {
                "data": null,
                "orderable": false,
                "render": function (data, type, row) {
                    return '<button class="btn btn-warning update-btn" data-id="' + row.categoryId + '">Cập nhật</button>' +
                        '<button class="btn btn-danger delete-btn" data-id="' + row.categoryId + '">Xóa</button>';
                }
            }
        ]
    });

    // Xử lý sự kiện khi nhấn nút Cập nhật
    $('#categoryTable').on('click', '.update-btn', function () {
        var categoryId = $(this).data('id');
        window.location.href = "${pageContext.request.contextPath}/admin/category/edit?categoryid=" + categoryId;
    });

    // Xử lý sự kiện khi nhấn nút Xóa
    $('#categoryTable').on('click', '.delete-btn', function () {
        var categoryId = $(this).data('id');
        if (confirm("Bạn có chắc chắn muốn xóa category này?")) {
            $.ajax({
                url: "${pageContext.request.contextPath}/admin/category/delete",
                type: "POST",
                data: { categoryid: categoryId },
                success: function (response) {
                    alert("Xóa thành công!");
                    $('#categoryTable').DataTable().ajax.reload();
                },
                error: function (xhr, status, error) {
                    alert("Có lỗi xảy ra khi xóa category.");
                }
            });
        }
    });
});
</script>
</body>
</html>
