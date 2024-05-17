using LspCertification.Interfaces;
using LspCertification.Models;
using Microsoft.AspNetCore.Mvc;

namespace LspCertification.Controllers;

[ApiController]
[Route("api/[controller]")]
public class SpectaclesController : ControllerBase
{
    private readonly ISpectacleService _spectacleService;
    
    public SpectaclesController(ISpectacleService spectacleService)
    {
        _spectacleService = spectacleService;
    }
    
    [HttpGet]
    public async Task<IActionResult> GetAll()
    {
        var spectacles = await _spectacleService.GetAll();
        return Ok(spectacles);
    }
    
    [HttpGet("min")]
    public async Task<IActionResult> GetStock()
    {
        var spectacles = await _spectacleService.GetMin();
        return Ok(spectacles);
    }
    
    [HttpGet("{id:guid}")]
    public async Task<IActionResult> GetById([FromRoute] Guid id)
    {
        var spectacle = await _spectacleService.GetById(id);
        return Ok(spectacle);
    }
    
    [HttpPost]
    public async Task<IActionResult> Create([FromBody] SpectacleCreateRequest model)
    {
        var result = await _spectacleService.Create(model);
        return result ? Ok(new { message = "Spectacle created" }) : BadRequest(new { message = "Fail to create" });
    }
    
    [HttpPut("{id:guid}")]
    public async Task<IActionResult> Update([FromRoute] Guid id, [FromBody] SpectacleUpdateRequest model)
    {
        var result = await _spectacleService.Update(id, model);
        return result ? Ok(new { message = "Spectacle updated" }) : BadRequest(new { message = "Fail to update" });
    }
    
    [HttpDelete("{id:guid}")]
    public async Task<IActionResult> Delete([FromRoute] Guid id)
    {
        var result = await _spectacleService.Delete(id);
        return result ? Ok(new { message = "Spectacle deleted" }) : BadRequest(new { message = "Fail to delete" });
    }
}