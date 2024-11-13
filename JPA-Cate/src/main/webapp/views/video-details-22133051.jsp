<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Book Details</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="container mt-5">

    <h2 class="text-center mb-4">Chi Tiết Video</h2>

    <div class="row">
        <!-- Cột hiển thị poster -->
        <div class="col-md-4">
            <img src="${video.poster}" alt="Poster Image" style="width: 100%; height: auto; object-fit: cover;">
        </div>

        <!-- Cột hiển thị thông tin video -->
        <div class="col-md-8">
            <table class="table table-borderless">
                <tbody>
                    <tr>
                        <td><strong>Tiêu đề:</strong></td>
                        <td>${video.title}</td>
                    </tr>
                    <tr>
                        <td><strong>Mã video:</strong></td>
                        <td>${video.videoId}</td>
                    </tr>
                    <tr>
                        <td><strong>Category name:</strong></td>
                        <td>${cate.categoryName}</td>
                    </tr>
                    <tr>
                        <td><strong>View:</strong></td>
                        <td>${video.views}</td>
                    </tr>
                    <tr>
                        <td><a href="#" class="btn btn-primary">Share (10)</a></td>
                        <td><a href="#" class="btn btn-success">Like : ${likeCount}</a></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Phần mô tả của video -->
    <div class="mt-4">
        <h5><strong>Description:</strong></h5>
        <p>${video.description}</p>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
