package com.SavePoint.SavePoint.controller.interfaces;

import com.SavePoint.SavePoint.controller.request.CategoryRequest;
import com.SavePoint.SavePoint.controller.response.CategoryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Genero",description = "Elemento responsavel pelo gerenciamento de generos")
public interface CategoryController {

    @Operation(summary = "Listar todos as Genero", description = "Método para listar todos os generos")
    @ApiResponse(responseCode = "200", description = "Categoria listada com sucesso",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = CategoryResponse.class)))
    )
    @ApiResponse(responseCode = "404", description = "Genero não encontrado")
    public ResponseEntity<List<CategoryResponse>> findAll();


    @Operation(summary = "Encontrar Genero", description = "Metodo para encontrar genero pelo ID" ,
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Categoria encontrada com sucesso!",
            content = @Content(schema = @Schema(implementation = CategoryResponse.class))
    )
    @ApiResponse (responseCode = "404", description = "Categoria não encontrada!")
    public ResponseEntity<CategoryResponse> findById(@PathVariable Long id);


    @Operation(summary = "Salvar Genero", description = "Metodo para salvar genero" ,
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Genero salvo com sucesso",
            content = @Content(schema = @Schema(implementation = CategoryResponse.class))
    )
    public ResponseEntity <CategoryResponse> saveCategory(@Valid @RequestBody CategoryRequest request);


    @Operation(summary = "Atualizar Genero", description = "Metodo para atualizar genero" ,
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Genero atualizado com sucesso",
            content = @Content(schema = @Schema(implementation = CategoryResponse.class))
    )
    public ResponseEntity<CategoryResponse> update(@PathVariable Long id, @Valid @RequestBody CategoryRequest request);


    @Operation(summary = "Deletar Genero", description = "Metodo para deletar genero" ,
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204", description = "Genero deletado com sucesso",
            content = @Content(schema = @Schema(implementation = CategoryResponse.class))
    )
    @ApiResponse (responseCode = "404", description = "Genero não encontrado!")
    public ResponseEntity<Void> delete (@PathVariable Long id);

}
