using Dapper;
using LspCertification.Data;
using LspCertification.Interfaces;
using LspCertification.Models;

namespace LspCertification.Services;

public class SpectacleService : ISpectacleService
{
    private DapperContext _dapperContext;
    
    public SpectacleService(DapperContext dapperContext)
    {
        _dapperContext = dapperContext;
    }
    
    public async Task<List<SpectacleResource>> GetAll()
    {
        using var connection = _dapperContext.CreateConnection();
        const string sql = """
                           
                                       SELECT SpectacleId
                                           ,SpectacleType
                                           ,SpectacleCode
                                           ,SpectacleBrand
                                           ,Price
                                           ,Stock
                                           ,s.DistributorId
                                           ,d.DistributorName AS Distributor
                                       FROM Spectacles AS s
                                       LEFT JOIN Distributors AS d ON s.DistributorId = d.DistributorId
                                       WHERE s.IsDeleted = 0
                                   
                           """;
        var spectacles = await connection.QueryAsync<SpectacleResource>(sql);
        return spectacles.ToList();
    }
    
    public async Task<List<SpectacleResource>> GetMin()
    {
        using var connection = _dapperContext.CreateConnection();
        const string sql = """
                           
                                       SELECT SpectacleId
                                           ,SpectacleType
                                           ,SpectacleCode
                                           ,SpectacleBrand
                                           ,Price
                                           ,Stock
                                           ,s.DistributorId
                                           ,d.DistributorName AS Distributor
                                       FROM Spectacles AS s
                                       LEFT JOIN Distributors AS d ON s.DistributorId = d.DistributorId
                                       WHERE s.IsDeleted = 0 AND Stock = (SELECT MIN(Stock) FROM Spectacles WHERE IsDeleted = 0)
                                   
                           """;
        
        
        var spectacles = await connection.QueryAsync<SpectacleResource>(sql);
        return spectacles.ToList();
    }
    
    public async Task<SpectacleResource> GetById(Guid id)
    {
        using var connection = _dapperContext.CreateConnection();
        const string sql = """
                           
                                       SELECT SpectacleId
                                           ,SpectacleCode
                                           ,SpectacleType
                                           ,SpectacleBrand
                                           ,Price
                                           ,Stock
                                           ,s.DistributorId
                                           ,d.DistributorName AS Distributor
                                       FROM Spectacles AS s
                                       LEFT JOIN Distributors AS d ON s.DistributorId = d.DistributorId
                                       WHERE s.SpectacleId = @SpectacleId AND s.IsDeleted = 0
                                   
                           """;
        var spectacle = await connection.QueryFirstAsync<SpectacleResource>(sql, new
        {
            SpectacleId = id.ToString()
        });
        
        return spectacle;
    }
    
    public async Task<bool> Create(SpectacleCreateRequest model)
    {
        using var connection = _dapperContext.CreateConnection();
        const string sql = """
                           
                                       INSERT INTO Spectacles (SpectacleId, SpectacleCode, SpectacleType, SpectacleBrand, Price, Stock, DistributorId, IsDeleted, CreatedAt, LastModifiedAt)
                                       VALUES (@SpectacleId, @SpectacleCode, @SpectacleType, @SpectacleBrand, @Price, @Stock, @DistributorId, @IsDeleted, @CreatedAt, @LastModifiedAt)
                                   
                           """;
        var result = await connection.ExecuteAsync(sql, new
        {
            SpectacleId = Guid.NewGuid().ToString(),
            model.SpectacleCode, model.SpectacleType, model.SpectacleBrand, model.Price, model.Stock,
            DistributorId = model.DistributorId.ToString(),
            IsDeleted = false,
            CreatedAt = DateTime.Now,
            LastModifiedAt = DateTime.Now
        });
        
        return result > 0;
    }
    
    public async Task<bool> Update(Guid id, SpectacleUpdateRequest model)
    {
        using var connection = _dapperContext.CreateConnection();
        const string sql = """
                           
                                       UPDATE Spectacles
                                       SET SpectacleCode = @SpectacleCode,SpectacleType = @SpectacleType,SpectacleBrand = @SpectacleBrand,Price = @Price,Stock = @Stock,DistributorId = @DistributorId
                                       WHERE SpectacleId = @SpectacleId
                                   
                           """;
        var result = await connection.ExecuteAsync(sql, new
        {
            SpectacleId = id.ToString(), model.SpectacleCode, model.SpectacleType, model.SpectacleBrand, model.Price, model.Stock,
            DistributorId = model.DistributorId.ToString(),
        });
        
        return result > 0;
    }
    
    public async Task<bool> Delete(Guid id)
    {
        using var connection = _dapperContext.CreateConnection();
        const string sql = """
                           
                                       UPDATE Spectacles
                                       SET IsDeleted = 1
                                       WHERE SpectacleId = @SpectacleId
                                   
                           """;
        var result = await connection.ExecuteAsync(sql, new
        {
            SpectacleId = id.ToString()
        });
        
        return result > 0;
    }
}