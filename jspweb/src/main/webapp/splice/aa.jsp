<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<label>
    Zoom: <input type="range" min="10" max="1000" value="100" />
  </label>
  <button>Play/pause</button>
  <p>Open the console to see the event logs</p>


	<label><input type="checkbox" checked value="scrollbar" /> Scroll bar</label>
  <label><input type="checkbox" checked value="fillParent" /> Fill parent</label>
  <label><input type="checkbox" checked value="autoCenter" /> Auto center</label>

  <div style="margin: 1em 0 2em;">
    <button id="play">Play/Pause</button>
    <button id="backward">Backward 5s</button>
    <button id="forward">Forward 5s</button>
  </div>


	<script src="aa.js" type="text/javascript"></script>
	
</body>
</html>