function save_reg() {
    console.log("КНОПКА СРАБОТАЛА");

    var em_date = document.getElementById("email").value;
    var pas_date = document.getElementById("password").value;

    fetch("http://localhost:8080/registers", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            email: em_date,
            password: pas_date
        })
    });
}