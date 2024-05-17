using LspCertification.Data.Entities;
using LspCertification.Models;

namespace LspCertification.Interfaces;

public interface ISpectacleService
{
    Task<List<SpectacleResource>> GetAll();
    Task<List<SpectacleResource>> GetMin();
    Task<SpectacleResource> GetById(Guid id);
    Task<bool> Create(SpectacleCreateRequest model);
    Task<bool> Update(Guid id, SpectacleUpdateRequest model);
    Task<bool> Delete(Guid id);
}