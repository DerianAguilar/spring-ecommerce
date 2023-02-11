package com.curso.ecommerce.demo.Controller;


import com.curso.ecommerce.demo.Model.Producto;
import com.curso.ecommerce.demo.Model.Usuario;
import com.curso.ecommerce.demo.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/productos")
public class ProductoController {

    //private final Logger LOGGER = (Logger) LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private ProductoService productoService;

    @GetMapping("")
    public String show(Model model){
        model.addAttribute("productos",productoService.findAll());
        return "productos/show";
    }

    @GetMapping("/create")
    public String create(){
        return "productos/create";
    }

    @PostMapping("/save")
    public String save(Producto producto){

        System.out.println(producto.toString());

        Usuario usuario = new Usuario(1,"","","","","","","");

        producto.setUsuario(usuario);
        productoService.save(producto);
        return "redirect:/productos";
    }
}
