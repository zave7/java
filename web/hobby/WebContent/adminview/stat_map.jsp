<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
 
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Concept - Bootstrap 4 Admin Dashboard Template Google Map</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="../assets/vendor/bootstrap/css/bootstrap.min.css">
    <link href="../assets/vendor/fonts/circular-std/style.css" rel="stylesheet">
    <link rel="stylesheet" href="../assets/libs/css/style.css">
    <link rel="stylesheet" href="../assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
    <link rel="stylesheet" href="../assets/vendor/jvectormap/jquery-jvectormap-2.0.2.css">
</head>

<body>
    <!-- ============================================================== -->
    <!-- main wrapper -->
    <!-- ============================================================== -->
    <div class="dashboard-main-wrapper">
         <!-- ============================================================== -->
        <!-- navbar -->
        <!-- ============================================================== -->
        <jsp:include page="/template/header.jsp"/>
        <!-- ============================================================== -->
        <!-- end navbar -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- left sidebar -->
        <!-- ============================================================== -->
        <jsp:include page="/template/leftsidebar.jsp" />
        <!-- ============================================================== -->
        <!-- end left sidebar -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- wrapper  -->
        <!-- ============================================================== -->
        <div class="dashboard-wrapper">
            <div class="container-fluid dashboard-content">
                <!-- ============================================================== -->
                <!-- pageheader -->
                <!-- ============================================================== -->
                <div class="row">
                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                        <div class="page-header">
                            <h2 class="pageheader-title">지역별 레슨 통계</h2>
                            <p class="pageheader-text">Proin placerat ante duiullam scelerisque a velit ac porta, fusce sit amet vestibulum mi. Morbi lobortis pulvinar quam.</p>
                            <div class="page-breadcrumb">
                                <nav aria-label="breadcrumb">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="#" class="breadcrumb-link">통계</a></li>
                                        <li class="breadcrumb-item"><a href="#" class="breadcrumb-link">레슨</a></li>
                                        <li class="breadcrumb-item active" aria-current="page">지역</li>
                                    </ol>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- ============================================================== -->
                <!-- end pageheader -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- ======================== 조건 검색 ===================== -->
                <!-- ============================================================== -->
                <jsp:include page="../template/searchcondition.jsp"/>
                <!-- ============================================================== -->
                <!-- ======================== 조건 검색 끝 ===================== -->
                <!-- ============================================================== -->
                <div class="row">
                    <!-- ============================================================== -->
                    <!--korea -->
                    <!-- ============================================================== -->
                    <div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-12">
                        <div class="card">
                            <h5 class="card-header">korea</h5>
                            <div class="card-body">
                                <div id="korea" style="height: 450px;"></div>
                            </div>
                        </div>
                    </div>
                    <!-- ============================================================== -->
                    <!--end korea -->
                    <!-- ============================================================== -->
                </div>


                <!-- ============================================================== -->
                <!-- footer -->
                <!-- ============================================================== -->
                <jsp:include page="/template/footer.jsp" />
                <!-- ============================================================== -->
                <!-- end footer -->
                <!-- ============================================================== -->
            </div>
        </div>
    </div>
        <!-- ============================================================== -->
        <!-- end main wrapper -->
        <!-- ============================================================== -->
        <!-- Optional JavaScript -->
        <script src="../assets/vendor/jquery/jquery-3.3.1.min.js"></script>
        <script src="../assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
        <script src="../assets/vendor/slimscroll/jquery.slimscroll.js"></script>
        <script src="../assets/libs/js/main-js.js"></script>
        <script src="../assets/libs/js/gmaps.min.js"></script>
        <!-- jvactormap js -->
        <script src="../assets/vendor/jvectormap/jquery-jvectormap-2.0.2.min.js"></script>
        <script src="../assets/vendor/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
        <script src="../assets/vendor/jvectormap/jquery-jvectormap-kr-mill.js"></script>
        <script src="../assets/libs/js/jvectormap.custom.js"></script>
        <!-- 지역 클릭시 ajax 통신해서 값 얻어오기 -->
        <script src="../adminjs/map-korea.js"></script>
</body>
 
</html>