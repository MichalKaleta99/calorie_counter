<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<link href="css/search.css" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">


<div class="container">
    <h1> Zjedzone dziś </h1>
    <table class="table">
    <thead>
    <tr>
    <th>Nazwa </th>
    <th>Porcja (g) </th>
    <th>Białko</th>
    <th>Węglowodany</th>
    <th>Tłuszcze</th>
    <th>Sól</th>
    <th>Kalorie</th>
    <th></th>
    <th></th>

    </tr>

    </thead>

    <tbody>
    <c:forEach items="${eatenProducts}" var="eatenProduct">
    <tr>
    <td>${eatenProduct.name}</td>

      <input type="hidden" name="id" value="${eatenProduct.id}">
      <td><input type="text" name="mass" value="${eatenProduct.mass}" readonly></td>
      <td><button type="button" span class="material-icons blue">update</button></td>

    <td>${eatenProduct.protein}</td>
    <td>${eatenProduct.carbs}</td>
    <td>${eatenProduct.fat}</td>
    <td>${eatenProduct.salt}</td>
    <td>${eatenProduct.kcal}</td>


    <td><a href="delete-product?id=${eatenProduct.id}" span class="material-icons red">delete</span></td>

    </tr>
    </c:forEach>
    </tbody>
    </tbody>

        <tfoot>
          <tr>
            <h1><td colspan="1"><strong>Suma</strong></td></h1>
            <td id="mass">${summaryEaten.mass}</td>
            <td id="sum_protein">${summaryEaten.protein}</td>
            <td id="sum_carbs">${summaryEaten.carbs}</td>
            <td id="sum_fat">${summaryEaten.fat}</td>
            <td id="sum_salt">${summaryEaten.salt}</td>
            <td id="sum_kcal">${summaryEaten.kcal}</td>
          </tr>
        </tfoot>
      </table>

</div>
<script>
  let buttons = document.querySelectorAll('button');
  // Loop through each button
  buttons.forEach(function(button) {
    // Add the click event listener to the button
    button.addEventListener('click', function() {
      // Find the input element with the name "mass" in the same form as the button
      let input = button.closest('form').querySelector('input[type="text"][name="mass"]');
      // Get the current value of the input element
      let currentValue = input.value;
      // Prompt the user for a new value
      let newValue = prompt('Enter the new value for mass:', currentValue);
      // If the user entered a new value, update the input element
      if (newValue) {
        input.value = newValue;
      }
    });
  });
</script>

    <%@ include file="common/footer.jspf" %>

