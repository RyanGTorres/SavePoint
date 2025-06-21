package com.SavePoint.SavePoint.controller.interfaces;

import com.SavePoint.SavePoint.controller.request.ReviewRequest;
import com.SavePoint.SavePoint.controller.response.GameResponse;
import com.SavePoint.SavePoint.controller.response.ReviewResponse;
import com.SavePoint.SavePoint.entity.Review;
import com.SavePoint.SavePoint.mapper.ReviewMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Review",description = "Elemento responsavel pelo gerenciamento de avaliações")
public interface ReviewController {

    @Operation(summary = "Listar todos as avaliaões", description = "Método para listar todos as avaliações")
    @ApiResponse(responseCode = "200", description = "Avaliação listada com sucesso",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = GameResponse.class)))
    )
    @ApiResponse(responseCode = "404", description = "Avaliação não encontrada")
    public ResponseEntity<List<ReviewResponse>> findAll();

    @Operation(summary = "Encontrar avaliação ID", description = "Metodo para encontrar avaliação pelo ID" ,
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Avaliação encontrada com sucesso",
            content = @Content(schema = @Schema(implementation = GameResponse.class))
    )
    @ApiResponse (responseCode = "404", description = "Avaliação não encontrada!")
    public ResponseEntity<ReviewResponse> findById(@PathVariable Long id);

    @Operation(summary = "Salvar avaliação", description = "Metodo para salvar Avaliação" ,
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Avaliação salvo com sucesso",
            content = @Content(schema = @Schema(implementation = GameResponse.class))
    )
    public ResponseEntity<ReviewResponse> save(@RequestBody ReviewRequest request);

    @Operation(summary = "Atualizar avaliação", description = "Metodo para atualizar avaliação" ,
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Avaliação atualizada com sucesso",
            content = @Content(schema = @Schema(implementation = GameResponse.class))
    )
    public ResponseEntity<ReviewResponse> update(@PathVariable Long id, @RequestBody ReviewRequest request);

    @Operation(summary = "Deletar avaliação", description = "Metodo para deletar avaliação" ,
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204", description = "Avaliação deletada com sucesso",
            content = @Content(schema = @Schema(implementation = GameResponse.class))
    )
    public ResponseEntity<Void> delete (@PathVariable Long id);
}
