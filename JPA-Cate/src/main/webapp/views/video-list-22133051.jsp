<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Danh sách Video theo Danh Mục</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="container mt-5">
    <h2 class="text-center mb-4">Danh sách Video theo Danh Mục</h2>

    <c:forEach var="entry" items="${cateVideos}">
        <c:set var="cate" value="${entry.key}" />
        <c:set var="videos" value="${entry.value}" />

        <div class="mb-4">
            <h3>Danh Mục: ${cate.categoryName}</h3>

            <table class="table table-bordered">
                <c:forEach var="video" items="${videos}">
                    <tr>
                        <!-- Cột hiển thị ảnh poster -->
                        <td style="width: 150px;">
                            <img src="${video.poster}" alt="Poster Image" style="width: 100px; height: auto; object-fit: cover;">
                        </td>
                        <!-- Cột hiển thị thông tin video -->
                        <td>
                            <p><strong>Tiêu đề:</strong> ${video.title}</p>
                            <p><strong>Mô tả:</strong> ${video.description}</p>
                            <p><strong>Lượt xem:</strong> ${video.views}</p>
                            <p><strong>Trạng thái:</strong> <c:choose><c:when test="${video.active}">Active</c:when><c:otherwise>Inactive</c:otherwise></c:choose></p>
                            <a href="video-details?id=${video.videoId}" class="btn btn-info">Chi tiết</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </c:forEach>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
