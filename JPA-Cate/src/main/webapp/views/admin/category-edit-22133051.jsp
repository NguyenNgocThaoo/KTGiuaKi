<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Chỉnh sửa Category</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <h2 class="text-center mb-4">Chỉnh sửa Category</h2>
    
    <form action="${pageContext.request.contextPath}/admin/category/update" method="post">
        <!-- Category ID -->
        <div class="form-group">
            <label for="categoryId">Category ID</label>
            <input type="text" class="form-control" id="categoryId" name="categoryId" value="${category.categoryId}" readonly>
        </div>

        <!-- Category Name -->
        <div class="form-group">
            <label for="categoryName">Category Name</label>
            <input type="text" class="form-control" id="categoryName" name="categoryName" value="${category.categoryName}" required>
        </div>

        <!-- Category Code -->
        <div class="form-group">
            <label for="categoryCode">Category Code</label>
            <input type="text" class="form-control" id="categoryCode" name="categoryCode" value="${category.categoryCode}" required>
        </div>

        <!-- Images -->
        <div class="form-group">
            <label for="images">Images</label>
            <input type="text" class="form-control" id="images" name="images" value="${category.images}" required>
        </div>

        <!-- Status -->
        <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="status" name="status" ${category.status ? "checked" : ""}>
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
