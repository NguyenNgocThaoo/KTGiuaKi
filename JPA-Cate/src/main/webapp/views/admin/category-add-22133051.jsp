<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Thêm Category</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <h2 class="text-center mb-4">Thêm Category</h2>
    
    <form action="${pageContext.request.contextPath}/admin/category/save" method="post">
        <!-- Category ID (ẩn khi thêm mới) -->
        <div class="form-group">
            <label for="categoryId">Category ID</label>
            <input type="text" class="form-control" id="categoryId" name="categoryId" placeholder="Category ID" readonly>
        </div>

        <!-- Category Name -->
        <div class="form-group">
            <label for="categoryName">Category Name</label>
            <input type="text" class="form-control" id="categoryName" name="categoryName" placeholder="Nhập tên danh mục" required>
        </div>

        <!-- Category Code -->
        <div class="form-group">
            <label for="categoryCode">Category Code</label>
            <input type="text" class="form-control" id="categoryCode" name="categoryCode" placeholder="Nhập mã danh mục" required>
        </div>

        <!-- Images -->
        <div class="form-group">
            <label for="images">Images</label>
            <input type="text" class="form-control" id="images" name="images" placeholder="Nhập đường dẫn ảnh" required>
        </div>

        <!-- Status -->
        <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="status" name="status">
            <label class="form-check-label" for="status">Status</label>
        </div>

        <!-- Submit Button -->
        <button type="submit" class="btn btn-primary">Lưu</button>
        <a href="${pageContext.request.contextPath}/admin/category" class="btn btn-secondary">Quay lại</a>
    </form>
</div>

<!-- Bootstrap JS và các thư viện phụ thuộc -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
