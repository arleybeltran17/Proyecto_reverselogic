document.addEventListener("DOMContentLoaded", function() {
        console.log("Entrando.........")
        let updateButtons = document.querySelectorAll(".btncal");
        console.log("Entro.........")
        console.log("Accediendo A Los Valores.........")
    
        updateButtons.forEach((button) => {
            button.addEventListener("click", (e) => {
              e.preventDefault();
          
              const modal = document.getElementById("myModal1");
              const form = modal.querySelector("form");
          
              const cardElement = button.parentElement.parentElement;
              const MateId = cardElement.querySelector(".cardMate_Id").textContent;
          
              // Comprobar si existe el elemento .cardMateNombre
              let MateNombreElement = cardElement.querySelector(".cardMateNombre");
              if (MateNombreElement) {
                const MateNombre = MateNombreElement.textContent;
          
                form.elements.Mate_Id.value = MateId;
                form.elements.Mate_Nombre.value = MateNombre;
              } else {
                console.error("El elemento .cardMateNombre no existe");
              }
          
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