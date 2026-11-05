package practica_01.controller;

import practica_01.domain.Suculenta;
import practica_01.service.SuculentaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SuculentaController {

    private final SuculentaService suculentaService;

    public SuculentaController(SuculentaService suculentaService) {
        this.suculentaService = suculentaService;
    }

    // Mostrar listado de suculentas
    @GetMapping("/suculenta/listado")
    public String listado(Model model) {

        var suculentas = suculentaService.listarSuculentas();

        model.addAttribute("suculentas", suculentas);

        return "suculenta/listado";
    }

    // Mostrar formulario para crear una suculenta
    @GetMapping("/suculenta/nuevo")
    public String nuevo(Model model) {

        model.addAttribute("suculenta", new Suculenta());

        return "suculenta/modifica";
    }

    // Guardar una suculenta
    @PostMapping("/suculenta/guardar")
    public String guardar(
            @ModelAttribute Suculenta suculenta,
            RedirectAttributes redirectAttributes) {

        suculentaService.guardarSuculenta(suculenta);

        redirectAttributes.addFlashAttribute(
                "mensaje", "Suculenta guardada correctamente");

        return "redirect:/suculenta/listado";
    }

    // Mostrar formulario para editar una suculenta
    @GetMapping("/suculenta/modificar/{id}")
    public String modificar(
            @PathVariable Integer id,
            Model model,
            RedirectAttributes redirectAttributes) {

        var suculenta = suculentaService.buscarSuculenta(id);

        if (suculenta.isEmpty()) {

            redirectAttributes.addFlashAttribute(
                    "error", "La suculenta no existe");

            return "redirect:/suculenta/listado";
        }

        model.addAttribute("suculenta", suculenta.get());

        return "suculenta/modifica";
    }

    // Eliminar una suculenta
    @PostMapping("/suculenta/eliminar/{id}")
    public String eliminar(
            @PathVariable Integer id,
            RedirectAttributes redirectAttributes) {

        if (suculentaService.buscarSuculenta(id).isEmpty()) {

            redirectAttributes.addFlashAttribute(
                    "error", "La suculenta no existe");

            return "redirect:/suculenta/listado";
        }

        suculentaService.eliminarSuculenta(id);

        redirectAttributes.addFlashAttribute(
                "mensaje", "Suculenta eliminada correctamente");

        return "redirect:/suculenta/listado";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
