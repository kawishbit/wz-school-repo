namespace LspCertification.Data.Entities;

public class BaseEntity
{
    public bool IsDeleted { get; set; }
    
    public DateTime CreatedAt { get; set; } = DateTime.Now;
    
    public DateTime? LastModifiedAt { get; set; } = DateTime.Now;
}