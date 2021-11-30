$(document).ready(function () {
    // Activate tooltip
    $('[data-toggle="tooltip"]').tooltip();

    // Select/Deselect checkboxes
    var checkbox = $('table tbody input[type="checkbox"]');
    $("#selectAll").click(function () {
        if (this.checked) {
            checkbox.each(function () {
                this.checked = true;
            });
        } else {
            checkbox.each(function () {
                this.checked = false;
            });
        }
    });
    checkbox.click(function () {
        if (!this.checked) {
            $("#selectAll").prop("checked", false);
        }
    });
});

$(document).on("click", ".edit", function () {
    var id = $(this).data('id');
    var name = $(this).data('name');
    var price = $(this).data('price');
    var image = $(this).data('image');
    var quantity = $(this).data('quantity');
    var category = $(this).data('category');
    var description = $(this).data('description');
    var status = $(this).data('status');
    var date = $(this).data('date');

    $(".modal-body #id").val(id);
    $(".modal-body #name").val(name);
    $(".modal-body #price").val(price);
    $(".modal-body #image").val(image);
    $(".modal-body #image-product").attr("src", image);
    $(".modal-body #quantity").val(quantity);
    $(".modal-body #category").val(category);
    $(".modal-body #category").html(category);
    $(".modal-body #description").val(description);
    $(".modal-body #status").val(status);
    $(".modal-body #status").html(status);
    $(".modal-body #date").val(date);
});

$(document).on("click", ".delete", function () {
    var id = $(this).data('id');

    $(".modal-footer #userID").val(id);
});

$(document).on("click", ".edit-category", function () {
    var name = $(this).data('name');
    var id = $(this).data('id');

    $(".modal-body #name").val(name);
    $(".modal-body #id").val(id);

});
