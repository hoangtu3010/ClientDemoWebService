<%@ page import="com.example.ClientDemo3.entity.Product" %>
<%@ page import="java.math.BigDecimal" %>
<%
    Product obj = (Product) request.getAttribute("product");
%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="/css/form-custom.css">
    <title>Create new products</title>
</head>
<body>
<div class="container">
    <h1 class="text-center"><p><%= obj.getId() == null ? "Create new product" : "Edit product" %>
    </p>
    </h1>
    <a href="/products" class="btn btn-custom mb-5"><i class="bi bi-arrow-left"></i> Back to list</a>
    <div class="form-section">
        <form action="<%= obj.getId() == null ? "/products/create" : "/products/update" %>" method="post"
              name="create-form">
            <div class="mb-3">
                <label class="form-label">Name</label>
                <input type="hidden" name="id" value="<%= obj.getId() %>">
                <input type="text" name="name" class="form-control"
                       value="<%= obj.getName() != null ? obj.getName() : "" %>">
            </div>
            <div class="mb-3">
                <label class="form-label">Price</label>
                <input type="number" name="price" class="form-control" aria-describedby="emailHelp"
                       value="<%= obj.getPrice().compareTo(new BigDecimal(0)) > 0 ? obj.getPrice() : 0 %>">
            </div>
            <div class="text-center">
                <button type="submit"
                        class="btn btn-custom btn-submit-custom"><%= obj.getId() == null ? "Submit" : "Update" %>
                </button>
            </div>

        </form>
    </div>
</div>
</body>
</html>
