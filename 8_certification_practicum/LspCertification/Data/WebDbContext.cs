using LspCertification.Data.Entities;
using Microsoft.EntityFrameworkCore;

namespace LspCertification.Data;

public class WebDbContext(DbContextOptions<WebDbContext> options) : DbContext(options)
{
    public DbSet<Spectacle> Spectacles { get; set; } = null!;
    public DbSet<Distributor> Distributors { get; set; } = null!;
    
    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<Distributor>()
                    .HasMany(x => x.Spectacles)
                    .WithOne(x => x.Distributor)
                    .HasForeignKey(x => x.DistributorId)
                    .IsRequired();
        
        
        
    }
}