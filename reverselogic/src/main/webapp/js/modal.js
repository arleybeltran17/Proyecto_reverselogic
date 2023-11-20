//? -------------------------|| Modal Actualizacion Productos ||-------------------------
let updateButtons = document.querySelectorAll(".btncal");

updateButtons.forEach(function(button) {
    button.addEventListener("click", function() {
        let modal = document.getElementById("myModal1");
        let form = modal.querySelector("form");

        // Obtener los valores ingresados por el usuario en la tarjeta
        let ProdId = button.getAttribute("data-prod-id");
        let ProdNombre = button.parentElement.querySelector(".cardProdname").textContent;
        let ProdCant = button.parentElement.querySelector(".cardProdCant").textContent;
        let ProdPrecioUni = button.parentElement.querySelector(".cardProdPrecioUni").textContent;
        let ProdMateId = button.parentElement.querySelector(".cardMateId").textContent;

        // Llenar los campos en la ventana modal con los valores obtenidos
        form.Prod_id.value = ProdId;
        form.Prod_Nombre.value = ProdNombre;
        form.Prod_Cant.value = ProdCant;
        form.Prod_PrecioUni.value = ProdPrecioUni;
        form.Mate_Id.value = ProdMateId;

        // Mostrar la ventana modal
        modal.style.display = "block";
    });
});

// Aquí, getUserById() es una función ficticia, debes implementarla para obtener los datos del usuario por su ID
function getProdById(ProdId, callback) {
    // Aquí, realiza una solicitud AJAX al servidor o cualquier otra lógica para obtener los datos del usuario
    // Supongamos que userData es un objeto que contiene la información del usuario por su ID
    let ProdData = {
        Prod_id: ProdId,
        Prod_Nombre: ProdNombre,
        Prod_Cant: ProdCant,
        Prod_PrecioUni: ProdPrecioUni,
        Mate_Id: ProdMateId
    };

    // Llamar al callback con los datos del usuario
    callback(ProdData);
}

// Evento de cierre de la ventana modal
let modal = document.getElementById("myModal1");
let closeBtn = document.querySelector(".close1");

closeBtn.addEventListener("click", function() {
    modal.style.display = "none";
});

window.addEventListener("click", function(event) {
    if (event.target === modal) {
        modal.style.display = "none";
    }
});