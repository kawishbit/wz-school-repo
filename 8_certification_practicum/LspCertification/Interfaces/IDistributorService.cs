using LspCertification.Models;

namespace LspCertification.Interfaces;

public interface IDistributorService
{
    Task<List<DistributorModels>> GetAll();
    Task<DistributorModels> GetById(Guid id);
    Task<bool> Create(DistributorCreateRequest model);
    Task<bool> Update(Guid id, DistributorUpdateRequest model);
    Task<bool> Delete(Guid id);
}