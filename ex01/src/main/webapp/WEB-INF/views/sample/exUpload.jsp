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

<!-- ������ MVC�� ���޵Ǵ� �Ķ���Ͱ� ������ �̸����� ������ �����ϸ� �迭��ó���� �����ϹǷ� �Ķ���͸� MultipartFile �� �迭 Ÿ������ �ۼ��Ѵ�.
������ ������ ���ε��� ���� �Ʒ��� ���� ����� �� �� �ִ�. ���� ������ �� ������ �ִ� ũ�Ⱑ 2MB �̹Ƿ� �׺��� ���� ũ���� ������ �����ؼ� ���ε带 �׽�Ʈ�Ѵ�.
���� �׸����� �߰��� ���̴� �α״� SampleController���� ���ε� ������ �ùٸ��� ó���Ǵ� ���� �����ְ� �ִ�. ���� ���ε带 �Ϸ���byte[]
�� ó���ؾ� �ϴµ������� ���� ó������ ���� �����̴� 

 exUpload.jsp �� �������� ������ �Ѳ����� ���ε��ϴ� ������ �ۼ��� ����. <form>�±��� action�Ӽ�, method �Ӽ�, enctype �Ӽ���
 �����ؼ� �ۼ��ؾ��Ѵ�. �������� �Ʒ��Ͱ��� ������� ���δ�.
 
 exUpload.jsp�� action �Ӽ����� 'sample/exUploadPost'�� �ۼ��Ǿ�����, �̿� �´� �޼��带 SampleController�� �߰��Ѵ�. -->