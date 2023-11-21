document.addEventListener("DOMContentLoaded", function() {
        console.log("Entrando.........")
        let updateButtons = document.querySelectorAll(".btncal");
        console.log("Entro.........")
        console.log("Accediendo A Los Valores.........")
    
    updateButtons.forEach(function(button) {
        button.addEventListener("click", function(e) {
            e.preventDefault()
            console.log("Listo :3.........")
            let modal = document.getElementById("myModal1");
            let form = modal.querySelector("form");
   
            console.log("Obteniendo Valores De Cards :3.........")
            // Obtener los valores ingresados por el usuario en la tarjeta
            let MateId = button.getAttribute("data-mate-id");
            let MateNombre = button.parentElement.querySelector(".cardMateNombre").textContent;
    
            // Llenar los campos en la ventana modal con los valores obtenidos
            form.elements.Mate_Id.value = MateId;
            form.elements.Mate_Nombre.value = MateNombre;
            console.log("Obtenidos Correctamente :3.........")
    
            // Mostrar la ventana modal
            modal.style.display = "block";
        });
    });
    
    // Aquí, getUserById() es una función ficticia, debes implementarla para obtener los datos del usuario por su ID
    function getMaterialById(MateId, callback) {
        // Aquí, realiza una solicitud AJAX al servidor o cualquier otra lógica para obtener los datos del usuario
        // Supongamos que userData es un objeto que contiene la información del usuario por su ID
        let MateData = {
            Mate_Id: MateId,
            Mate_Nombre: MateNombre,
        };
    
        // Llamar al callback con los datos del usuario
        callback(MateData);
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