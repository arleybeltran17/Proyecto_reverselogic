//? -------------------------|| Modal Actualizacion Venta ||-------------------------
document.addEventListener("DOMContentLoaded", function() {
    let updateButtons = document.querySelectorAll(".btncal");

    updateButtons.forEach(function(button) {
        button.addEventListener("click", function(e) {

            console.log("Botón clickeado");
            let modal = document.getElementById("myModal1");

            // Agregar este console.log para verificar si modal es null
            console.log("Modal element:", modal);

            let form = modal.querySelector("form");

            // Obtener los valores ingresados por el usuario en la tarjeta
            let Vent_Id = button.getAttribute("data-venta-id");
            let Vent_Cantidad = button.parentElement.querySelector(".cardVent_Cantidad").textContent;
            let Vent_Fecha = button.parentElement.querySelector(".cardVent_Fecha").textContent;
            let Usu_Id = button.parentElement.querySelector(".cardUsu_Id").textContent;
            let Clie_Id = button.parentElement.querySelector(".cardClie_Id").textContent;
            let Metod_Id = button.parentElement.querySelector(".cardMetod_Id").textContent;
            let Prend_Id = button.parentElement.querySelector(".cardPrend_Id").textContent;
    
           
            // Llenar los campos en la ventana modal con los valores obtenidos
            form.elements.Vent_Id.value = Vent_Id;
            form.elements.Vent_Cantidad.value = Vent_Cantidad;
            form.elements.Vent_Fecha.value = Vent_Fecha;
            form.elements.Usu_Id.value = Usu_Id;
            form.elements.Clie_Id.value = Clie_Id;
            form.elements.Metod_Id.value = Metod_Id;
            form.elements.Prend_Id.value = Prend_Id;
            // Mostrar la ventana modal
            modal.style.display = "block";
        });
    });
    
    // Aquí, getUserById() es una función ficticia, debes implementarla para obtener los datos del usuario por su ID
    function getProdById(Vent_Id, callback) {
        // Aquí, realiza una solicitud AJAX al servidor o cualquier otra lógica para obtener los datos del usuario
        // Supongamos que userData es un objeto que contiene la información del usuario por su ID
        let VentData = {
            Vent_Id: Vent_Id,
            Vent_Cantidad: Vent_Cantidad,
            Vent_Fecha: Vent_Fecha,
            Usu_Id: Usu_Id,
            Clie_Id: Clie_Id,
            Metod_Id: Metod_Id,
            Prend_Id: Prend_Id
        };
    
        // Llamar al callback con los datos del usuario
        callback(VentData);
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
});
