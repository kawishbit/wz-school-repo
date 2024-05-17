using Dapper;
using LspCertification.Data;
using LspCertification.Data.Entities;
using LspCertification.Interfaces;
using LspCertification.Models;

namespace LspCertification.Services;

public class DistributorService : IDistributorService
{
    private DapperContext _dapperContext;
    
    public DistributorService(DapperContext dapperContext)
    {
        _dapperContext = dapperContext;
    }
    
    public async Task<List<DistributorModels>> GetAll()
    {
        using var connection = _dapperContext.CreateConnection();
        const string sql = """
                           
                                       SELECT DistributorId
                                           ,DistributorCode
                                           ,DistributorName
                                           ,Address
                                           ,EmailAddress
                                           ,PhoneNumber
                                           ,ContactPerson
                                           ,IsDeleted
                                           ,CreatedAt
                                           ,LastModifiedAt
                                       FROM Distributors
                                       WHERE IsDeleted = 0
                                   
                           """;
        var distributors = await connection.QueryAsync<DistributorModels>(sql);
        return distributors.ToList();
    }
    
    public async Task<DistributorModels> GetById(Guid id)
    {
        using var connection = _dapperContext.CreateConnection();
        const string sql = """
                           
                                       SELECT DistributorId
                                           ,DistributorCode
                                           ,DistributorName
                                           ,Address
                                           ,EmailAddress
                                           ,PhoneNumber
                                           ,ContactPerson
                                           ,IsDeleted
                                           ,CreatedAt
                                           ,LastModifiedAt
                                       FROM Distributors
                                       WHERE DistributorId = @DistributorId AND IsDeleted = 0
                                   
                           """;
        var distributor = await connection.QueryFirstAsync<DistributorModels>(sql, new
        {
            DistributorId = id.ToString()
        });
        return distributor;
    }
    
    public async Task<bool> Create(DistributorCreateRequest model)
    {
        using var connection = _dapperContext.CreateConnection();
        const string sql = """
                           
                                       INSERT INTO Distributors (DistributorId, DistributorCode, DistributorName, Address, EmailAddress, PhoneNumber, ContactPerson, IsDeleted, CreatedAt, LastModifiedAt)
                                       VALUES (@DistributorId, @DistributorCode, @DistributorName, @Address, @EmailAddress, @PhoneNumber, @ContactPerson, @IsDeleted, @CreatedAt, @LastModifiedAt)
                                   
                           """;
        var result = await connection.ExecuteAsync(sql, new 
        {
            DistributorId = Guid.NewGuid().ToString(), model.DistributorCode, model.DistributorName, model.Address, model.EmailAddress, model.PhoneNumber, model.ContactPerson,
            IsDeleted = false,
            CreatedAt = DateTime.Now,
            LastModifiedAt = DateTime.Now
        });
        
        return result > 0;
    }
    
    public async Task<bool> Update(Guid id, DistributorUpdateRequest model)
    {
        using var connection = _dapperContext.CreateConnection();
        const string sql = """
                           
                                       UPDATE Distributors
                                       SET DistributorCode = @DistributorCode, DistributorName = @DistributorName, Address = @Address, EmailAddress = @EmailAddress, PhoneNumber = @PhoneNumber, ContactPerson = @ContactPerson
                                       WHERE DistributorId = @DistributorId
                                   
                           """;
        var result = await connection.ExecuteAsync(sql, new
        {
            DistributorId = id.ToString(), model.DistributorCode, model.DistributorName, model.Address, model.EmailAddress, model.PhoneNumber, model.ContactPerson
        });
        
        return result > 0;
    }
    
    public async Task<bool> Delete(Guid id)
    {
        using var connection = _dapperContext.CreateConnection();
        const string sql = """
                           
                                       UPDATE Distributors
                                       SET IsDeleted = 1
                                       WHERE DistributorId = @DistributorId
                                   
                           """;
        var result = await connection.ExecuteAsync(sql, new
        {
            DistributorId = id.ToString()
        });
        
        return result > 0;
    }
}