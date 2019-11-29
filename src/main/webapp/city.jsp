<%@page pageEncoding="utf-8" isELIgnored="false" contentType="text/html; utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <script>
        $(function () {
            $.ajax({
                url: "${pageContext.request.contextPath}/select/province",
                type: "get",
                dataType: "json",
                success: function (data) {
                    $.each(data, function (index, province) {
                        var prOption = $("<option >").html(province.name).val(province.code);
                        $("#province").append(prOption);
                    });
                    $("#province").change();
                }
            })
            $("#province").change(function () {
                var provinceCode = $("#province").val();
                $.ajax({
                    url: "${pageContext.request.contextPath}/select/city",
                    type: "get",
                    data: {"provinceCode": provinceCode},
                    dataType: "json",
                    success: function (data) {
                        $("#city").empty();
                        $.each(data, function (index, city) {
                            var cityOption = $("<option >").html(city.name).val(city.code);
                            $("#city").append(cityOption);
                        });
                        $("#city").change();
                    }
                })
            })
            $("#city").change(function () {
                var cityCode = $("#city").val();
                $.ajax({
                    url: "${pageContext.request.contextPath}/select/area",
                    type: "get",
                    data: {"cityCode": cityCode},
                    dataType: "json",
                    success: function (data) {
                        $("#area").empty();
                        $.each(data, function (index, area) {
                            var areaOption = $("<option>").html(area.name)
                            $("#area").append(areaOption);
                        })
                        $("#area").change();
                    }
                })
            });

        })
    </script>
    <style>
        select {
            width: 100px;
        }
    </style>
</head>
<body>
省：<select id="province"></select>
市：<select id="city"></select>
县：<select id="area"></select>
</body>
</html>