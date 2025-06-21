package com.SavePoint.SavePoint.controller.interfaces;


import com.SavePoint.SavePoint.controller.request.GameRequest;
import com.SavePoint.SavePoint.controller.response.GameResponse;
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

@Tag(name = "Game",description = "Elemento responsavel pelo gerenciamento de jogos")
public interface GameController {

    @Operation(summary = "Salvar Jogo", description = "Metodo para salvar jogo" ,
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Jogo salvo com sucesso",
            content = @Content(schema = @Schema(implementation = GameResponse.class))
    )
    public ResponseEntity<GameResponse> save (@Valid @RequestBody GameRequest gameRequest);


    @Operation(summary = "Atualizar Jogo", description = "Metodo para atualizar jogo" ,
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Jogo atualizado com sucesso",
            content = @Content(schema = @Schema(implementation = GameResponse.class))
    )
    public ResponseEntity<GameResponse> update (@PathVariable Long id, @Valid @RequestBody GameRequest request);


    @Operation(summary = "Listar todos os Jogos", description = "Método para listar todos os jogos")
    @ApiResponse(responseCode = "200", description = "Jogo listado com sucesso",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = GameResponse.class)))
    )
    @ApiResponse(responseCode = "404", description = "Jogo não encontrado")
    public ResponseEntity <List<GameResponse>> findAll ();


    @Operation(summary = "Encontrar Jogo ID", description = "Metodo para encontrar jogo pelo ID" ,
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Jogo encontrado com sucesso!",
            content = @Content(schema = @Schema(implementation = GameResponse.class))
    )
    @ApiResponse (responseCode = "404", description = "Jogo não encontrado!")
    public ResponseEntity<GameResponse> findById(@PathVariable Long id);


    @Operation(summary = "Deletar Jogo", description = "Metodo para deletar jogo" ,
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204", description = "Jogo deletado com sucesso",
            content = @Content(schema = @Schema(implementation = GameResponse.class))
    )
    public ResponseEntity<Void> delete(@PathVariable Long id);
}
