$('.ylbt').on('click', function (e) {
    e.preventDefault();
})


const coursePay = {
    courseId: courseId,
    eventName: courseId + 999 + $("#eventName").text() + 0000 + $("#creator").text(),
    ategoryId: $("#categoryId").text(),
    expectedPrice: $("#expectedPrice").text(),
    description: $("#description").text()
};