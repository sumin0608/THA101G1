$('.ylbt').on('click', function (e) {
    e.preventDefault();

    const coursePay = {
        courseId: courseId,
        eventName: courseId + 999 + $("#eventName").text() + 0000 + $("#creator").text(),
        ategoryId: $("#categoryId").text(),
        expectedPrice: $("#expectedPrice").text(),
        description: $("#description").text()
    };

    $.ajax({
        url: "/ixercise/ecpayCheckout",
        type: "POST",
        dataType: "json",
        data: { coursePay: coursePay },
        success: function (resp) {
            console.log("Response:", resp);

        }, error: function (xhr, status, error) {
            alert("Error: " + xhr.responseText);
        }
    });

});