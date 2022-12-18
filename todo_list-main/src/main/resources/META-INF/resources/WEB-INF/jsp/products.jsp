<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<link href="css/search.css" rel="stylesheet"/>



<div class="container">
    <h1>Lista produktów </h1>

    <form:form method="post" modelAttribute="product">

    <h1>Wybrany produkt: <form:input type="text" value="" id="productName" path="productName" required="required"/></h1>
    <h1>Waga produktu [g] : <form:input type="text" value= "" onkeyup="myFunction2()"  id="mass" path="mass" required="required"/>
                <input type="submit" a href="product" class="btn btn-success"></a>
                </form:form>

    <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Znajdź produkt...">

    <tbody>

    <c:forEach items="${products}" var="product">
    <li class="listed_products">${product.name}</li>
    </c:forEach>

    </tbody>


</div>
<script>
function myFunction() {

  let li = document.getElementsByClassName('listed_products');
  var input, filter, ul, a, i, txtValue;
  input = document.getElementById('myInput');
  filter = input.value.toUpperCase();



  for (i = 0; i < li.length; i++) {
    a = li[i];
    console.log(a);
    txtValue = a.textContent || a.innerText;
    if (txtValue.toUpperCase().startsWith(filter)) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}


document.querySelectorAll('li').forEach((li) => {
    li.addEventListener('click', (event) => {
    var text = document.getElementById("productName");
    text.value = li.textContent;
    document.body.scrollTop = 0; // For Safari
    document.documentElement.scrollTop = 0;
    var searchBar = document.getElementById("myInput");
    searchBar.value = '';
    myFunction();

    });
});
function myFunction2(){
    var mass = document.getElementById("mass");
    let pattern = /^[\d.]+$/;

    if (!pattern.test(mass.value)) {
      alert("Zły znak! (Tylko cyfry lub kropka są akceptowane)");
      mass.value = mass.value.replace(/[^\d]/g, "");
    }
}

var mass = document.getElementById("mass");
        if(mass.value==0.0){
        mass.value='';
        }



</script>

    <%@ include file="common/footer.jspf" %>

