package com.curso.ecommerce.demo.Controller;


import com.curso.ecommerce.demo.Model.Producto;
import com.curso.ecommerce.demo.Model.Usuario;
import com.curso.ecommerce.demo.Service.ProductoService;
import com.curso.ecommerce.demo.Service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;


@Controller
@RequestMapping("/productos")
public class ProductoController {

    //private final Logger LOGGER = (Logger) LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private ProductoService productoService;

    @Autowired
    private UploadFileService uploadFileService;

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
    public String save(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {

        System.out.println(producto.toString());

        Usuario usuario = new Usuario(1,"","","","","","","");

        producto.setUsuario(usuario);

        //imagen

        if(producto.getId()==null){ //cuando se crea un producto
            String nombreImagen = uploadFileService.saveImage(file);
            producto.setImagen(nombreImagen);
        }else{
            if(file.isEmpty()){//Editamos el producto pero no cambiamos la imagen
                Producto p = new Producto();
                p= productoService.get(producto.getId()).get();
                producto.setImagen(p.getImagen());
            }else{
                String nombreImagen = uploadFileService.saveImage(file);
                producto.setImagen(nombreImagen);
            }
        }


        productoService.save(producto);
        return "redirect:/productos";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable Integer id, Model model){
        Producto producto = new Producto();
        Optional<Producto> optionalProducto = productoService.get(id);
        producto= optionalProducto.get();

        System.out.println("Producto buscado ="+producto);
        model.addAttribute("producto",producto);

        return "productos/edit";
    }

    @PostMapping("/update")
    public String update(Producto producto){
        productoService.update(producto);

        return "redirect:/productos";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        productoService.delete(id);

        return "redirect:/productos";
    }
}
