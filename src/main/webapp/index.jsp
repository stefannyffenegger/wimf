<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>
<head>
  <script src="js/jquery-3.4.1.min.js"></script>
</head>
<body>
  <h1>Pure JS Barcode Reader</h1>
  <div>Barcode result: <span id="dbr"></span></div>
  <div class="select">
    <label for="videoSource">Video source: </label><select id="videoSource"></select>
  </div>
  <button id="go">Read Barcode</button>
  <div>
    <video muted autoplay id="video" playsinline="true"></video>
    <canvas id="pcCanvas" width="640" height="480" style="display: none; float: bottom;"></canvas>
    <canvas id="mobileCanvas" width="240" height="320" style="display: none; float: bottom;"></canvas>
  </div>
</body>

<script async src="js/zxing.js"></script>
<script src="js/video.js"></script>
</html>