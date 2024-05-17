using LspCertification.Interfaces;
using LspCertification.Models;
using Microsoft.AspNetCore.Mvc;

namespace LspCertification.Controllers;

[ApiController]
[Route("api/[controller]")]
public class DistributorsController : ControllerBase
{
    private readonly IDistributorService _distributorService;
    
    public DistributorsController(IDistributorService distributorService)
    {
        _distributorService = distributorService;
    }
    
    [HttpGet]
    public async Task<IActionResult> GetAll()
    {
        var distributors = await _distributorService.GetAll();
        return Ok(distributors);
    }
    
    [HttpGet("{id:guid}")]
    public async Task<IActionResult> GetById([FromRoute] Guid id)
    {
        var distributor = await _distributorService.GetById(id);
        return Ok(distributor);
    }
    
    [HttpPost]
    public async Task<IActionResult> Create([FromBody] DistributorCreateRequest model)
    {
        var result = await _distributorService.Create(model);
        return result ? Ok(new { message = "Distributor created" }) : BadRequest(new { message = "Fail to create" });
    }
    
    [HttpPut("{id:guid}")]
    public async Task<IActionResult> Update([FromRoute] Guid id, [FromBody] DistributorUpdateRequest model)
    {
        var result = await _distributorService.Update(id, model);
        return result ? Ok(new { message = "Distributor updated" }) : BadRequest(new { message = "Fail to update" });
    }
    
    [HttpDelete("{id:guid}")]
    public async Task<IActionResult> Delete([FromRoute] Guid id)
    {
        var result = await _distributorService.Delete(id);
        return result ? Ok(new { message = "Distributor deleted" }) : BadRequest(new { message = "Fail to delete" });
    }
}