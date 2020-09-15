<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<form action="/sample/exUploadPost" method="post" enctype="multipart/form-data">

<div>
 <input type='file' name='files'>
</div>
<div>
 <input type='file' name='files'>
</div>

<div>
 <input type='file' name='files'>
</div>

<div>
 <input type='file' name='files'>
</div>

<div>
 <input type='file' name='files'>
</div>

<div>
 <input type='submit'>
</div>



</form>
</body>
</html>

<!-- 스프링 MVC는 전달되는 파라미터가 동일한 이름으로 여러개 존재하면 배열로처리가 간으하므로 파라미터를 MultipartFile 의 배열 타입으로 작성한다.
실제로 파일을 업로드해 보면 아래와 같은 결과를 볼 수 있다. 현재 설정은 한 파일의 최대 크기가 2MB 이므로 그보다 작은 크기의 파일을 지정해서 업로드를 테스트한다.
위의 그림에서 중간에 보이는 로그는 SampleController에서 업로드 정보가 올바르게 처리되는 것을 보여주고 있다. 최종 업로드를 하려면byte[]
를 처리해야 하는데예제는 아직 처리하지 않은 상태이다 

 exUpload.jsp 는 여러개의 파일을 한꺼번에 업로드하는 예제로 작성해 본다. <form>태그의 action속성, method 속성, enctype 속성에
 주의해서 작성해야한다. 브라우저는 아래와같은 모습으로 보인다.
 
 exUpload.jsp의 action 속성값은 'sample/exUploadPost'로 작성되었으며, 이에 맞는 메서드를 SampleController에 추가한다. -->